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
import java.util.concurrent.TimeUnit;

//TODO Calculo de coste de reserva.
// * sabado y domingo 15% mas caro
// * Apartir de 7 dias 10% de descuento

@Service
public class CostServiceImplementation implements CostService {


    // Repositories & Factories needed ------------------------------
    CostRepository costRepository;
    RoomRepository roomRepository;
    BookingRepository bookingRepository;
    CostFactory factory;

    // Constructor --------------------------------------------------
    @Autowired
    public CostServiceImplementation(CostRepository costRepository, RoomRepository roomRepository, CostFactory factory, BookingRepository bookingRepository) {
        this.costRepository = costRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.factory = factory;
    }

    @Override
    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);
    }

    @Override
    public InvoiceDTO getInvoice(CostDTO costData) {
    //Entities
        List<CostEntity> costEntities = costRepository.test(Date.valueOf(costData.getPreCheckIn()), Date.valueOf(costData.getPreCheckOut()));
        RoomEntity roomEntity = roomRepository.findById(costData.idRoom);
        long clientBookings = bookingRepository.countByCliente_Id(costData.getClient());
        int pax = roomEntity.getNumpersonas();

        Date start = Date.valueOf(costData.getPreCheckIn());
        Date end = Date.valueOf(costData.getPreCheckOut());

        long totalDays = getDaysBetweenTwoDates(start, end);
        double defaultFlatPrice = totalDays * roomEntity.getPrecio();

        InvoiceDTO invoice = new InvoiceDTO();
        invoice.invoiceRows.add(new InvoiceRowDTO("Default Price", totalDays, defaultFlatPrice));


        double additionalCharges = 0;

        for (CostEntity costEntity : costEntities) {
            long daysToApplyDiscount = getDaysToApplyOffer(start, end, costEntity.getStarDate(),costEntity.getEndDate()); //definimos cuantos dias hay para cada tipo de negocio
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
        return invoice;
    }

    @Override
    public long getDaysToApplyOffer(Date checkIn, Date checkOut, Date startDateDiscount, Date endDateDiscount){
        long days = 1;
        if ((startDateDiscount.before(checkIn) || startDateDiscount.equals(checkIn)) && (checkOut.before(endDateDiscount) || checkOut.equals(endDateDiscount))){
            days = getDaysBetweenTwoDates(checkIn, checkOut);
        }
        else if ((startDateDiscount.before(checkIn) || startDateDiscount.equals(checkIn)) && (checkIn.before(endDateDiscount) || checkIn.equals(endDateDiscount)) && (endDateDiscount.before(checkOut) || endDateDiscount.equals(checkOut))){
            days = getDaysBetweenTwoDates(checkIn, endDateDiscount) + 1;
        }
        else if ((checkIn.before(startDateDiscount) || checkIn.equals(startDateDiscount))  && (endDateDiscount.before(checkOut) || endDateDiscount.equals(checkOut))){
            days = getDaysBetweenTwoDates(startDateDiscount, endDateDiscount) ;
        }
        else if ((checkIn.before(startDateDiscount) || checkIn.equals(startDateDiscount)) && (startDateDiscount.before(checkOut) || startDateDiscount.equals(checkOut)) && (checkOut.before(endDateDiscount) || checkOut.equals(endDateDiscount))){
            days = getDaysBetweenTwoDates(startDateDiscount, checkOut);
        }
        return days;
    }

    @Override
    public List<CostModel> showAllDiscounts() {
        List<CostEntity> entities = costRepository.findAll();
        List<CostModel> models = factory.costListEntity2Model(entities);
        return models;

    }
//    @Override
//    public float calculateCost(CostDTO costData) {
//
//        Date start = Date.valueOf(costData.getPreCheckIn());
//        Date end = Date.valueOf(costData.getPreCheckOut());
//
//
//        long nights = getDaysBetweenTwoDates(start, end);
//        long totalPrice = nights * costData.getPrecio();
//        System.out.println("night: " + nights + "Precio Hab: " + costData.getPrecio() + "fecha Entrada: " + start + "fecha Salida: " + end + "total: " + totalPrice);
//        return totalPrice;
//    }



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

//    @Override
//    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
//        long nights = DateService.getDaysBetweenTwoDates(checkIn, checkOut);
//        double totalPrice = nights * pricePerNight;
//        return totalPrice;
//    }

}
