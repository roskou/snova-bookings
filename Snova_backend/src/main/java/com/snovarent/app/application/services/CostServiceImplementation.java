package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.DTO.InvoiceRowDTO;
import com.snovarent.app.application.domain.entities.CostEntity;
import com.snovarent.app.application.domain.entities.RoomEntity;
import com.snovarent.app.application.domain.repositories.BookingRepository;
import com.snovarent.app.application.domain.repositories.CostRepository;
import com.snovarent.app.application.domain.repositories.RoomRepository;
import com.snovarent.app.application.factories.CostFactory;
import com.snovarent.app.application.models.CostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Random;


@Service
public class CostServiceImplementation implements CostService {


    // Repositories, Services & Factories needed ------------------------------
    CostRepository costRepository;
    RoomRepository roomRepository;
    BookingRepository bookingRepository;
    CostFactory factory;
    DateService dateService;

    // Constructor --------------------------------------------------
    @Autowired
    public CostServiceImplementation(CostRepository costRepository, RoomRepository roomRepository, CostFactory factory, BookingRepository bookingRepository, DateService dateService) {
        this.costRepository = costRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.factory = factory;
        this.dateService = dateService;
    }



    @Override
    public InvoiceDTO getInvoice(CostDTO costData) {
    //Entities
        List<CostEntity> costEntities = costRepository.test(costData.preCheckIn, costData.preCheckOut);
        RoomEntity roomEntity = roomRepository.findById(costData.idRoom);
        int pax = roomEntity.getNumpersonas();

        long clientBookings;
        if (costData.getClient() == 0){
            clientBookings = 0;
        } else{
            clientBookings = bookingRepository.countByCliente_Id(costData.getClient());
        }

        Date start = costData.preCheckIn;
        Date end = costData.preCheckOut;

        long totalDays = dateService.getDaysBetweenTwoDates(start, end);
        double defaultFlatPrice = totalDays * roomEntity.getPrecio();

        InvoiceDTO invoice = new InvoiceDTO();
        invoice.invoiceRows.add(new InvoiceRowDTO("Default Price", totalDays, defaultFlatPrice));


        double additionalCharges = 0;

        for (CostEntity costEntity : costEntities) {
            long daysToApplyDiscount = daysApplyCharges(start, end, costEntity.getStarDate(),costEntity.getEndDate()); //definimos cuantos dias hay para cada tipo de negocio
            float currentCharges = 0;


            if (costEntity.getAction() == 3) {
                int npaxdiscount = costEntity.getNpax();
                int nbookings = costEntity.getNbookings();

                if ((pax >= npaxdiscount && nbookings == 0) || (clientBookings >= nbookings && npaxdiscount == 0)) {
                    currentCharges = roomEntity.getPrecio() * costEntity.getFactor() * daysToApplyDiscount;
                    invoice.invoiceRows.add(new InvoiceRowDTO(costEntity.getDescription(), daysToApplyDiscount, currentCharges));
                }
            }

            else {
                currentCharges = roomEntity.getPrecio() * costEntity.getFactor() * daysToApplyDiscount;
                invoice.invoiceRows.add(new InvoiceRowDTO(costEntity.getDescription(), daysToApplyDiscount, currentCharges));
            }
            additionalCharges+= currentCharges;
        }
        invoice.additionalCharges = additionalCharges;
        invoice.finalPrice = defaultFlatPrice + additionalCharges;
        System.out.println(invoice.toString());
        return invoice;
    }

    @Override
    public long daysApplyCharges(Date checkIn, Date checkOut, Date startDateDiscount, Date endDateDiscount){
        long days = 1;
        if ((startDateDiscount.before(checkIn) || startDateDiscount.equals(checkIn)) && (checkOut.before(endDateDiscount) || checkOut.equals(endDateDiscount))){
            days = dateService.getDaysBetweenTwoDates(checkIn, checkOut);
        }
        else if ((startDateDiscount.before(checkIn) || startDateDiscount.equals(checkIn)) && (checkIn.before(endDateDiscount) || checkIn.equals(endDateDiscount)) && (endDateDiscount.before(checkOut) || endDateDiscount.equals(checkOut))){
            days = dateService.getDaysBetweenTwoDates(checkIn, endDateDiscount) + 1;
        }
        else if ((checkIn.before(startDateDiscount) || checkIn.equals(startDateDiscount))  && (endDateDiscount.before(checkOut) || endDateDiscount.equals(checkOut))){
            days = dateService.getDaysBetweenTwoDates(startDateDiscount, endDateDiscount) ;
        }
        else if ((checkIn.before(startDateDiscount) || checkIn.equals(startDateDiscount)) && (startDateDiscount.before(checkOut) || startDateDiscount.equals(checkOut)) && (checkOut.before(endDateDiscount) || checkOut.equals(endDateDiscount))){
            days = dateService.getDaysBetweenTwoDates(startDateDiscount, checkOut);
        }
        return days;
    }

    @Override
    public List<CostModel> showAllDiscounts() {
        List<CostEntity> entities = costRepository.findAll();
        List<CostModel> models = factory.costListEntity2Model(entities);
        return models;

    }

    @Override
    public String cuponGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }

}
