package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
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
import java.util.ArrayList;
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
    public List<InvoiceDTO> calculateFinalPrice(CostDTO costData) {

    //Queries
        List<CostEntity> costEntities = costRepository.test(Date.valueOf(costData.getPreCheckIn()), Date.valueOf(costData.getPreCheckOut()));
        RoomEntity roomEntity = roomRepository.findById(costData.idRoom);
        long clientBookings = bookingRepository.countByCliente_Id(costData.getClient());
        List<InvoiceDTO> invoice = new ArrayList<>();

    //vars
          Date start = Date.valueOf(costData.getPreCheckIn());
          Date end = Date.valueOf(costData.getPreCheckOut());
          int pax= (int) costData.getNpax();
        float fidelityDiscount = 0;
        float paxDiscount = 0;
          float flatPrice = roomEntity.getPrecio();
        float totalPrice=0;
        float totalDiscount=0;
        float sessonPrice=0;
        float eventPrice=0;
          int eventDays=0;



        System.out.println("| CheckIn: " + start + "  ##  CheckOut: " + end + " |");

    //iterate de offers
        for (CostEntity costEntity : costEntities) {

            long temp = getDaysToApplyOffer(start, end, costEntity.getStarDate(),costEntity.getEndDate()); //definimos cuantos dias hay para cada tipo de negocio
            float factor = costEntity.getFactor();
            int npax = costEntity.getNpax();
            int nbookings = costEntity.getNbookings();

            switch (costEntity.getAction()){

                case 1: //seasson Charge
                    sessonPrice += flatPrice * factor;
                    System.out.println( " ** " + costEntity.getDescription() + " || Dias: " + temp + " || " + "Tipo: " + costEntity.getAction() + " || " + (flatPrice * costEntity.getFactor()) + " || " + flatPrice);
                    break;

                case 2: //Especial event Charge
                    eventPrice += flatPrice * factor;

                    System.out.println( " ** " + costEntity.getDescription() + " || Dias: " + temp + " || " + "Tipo: " + costEntity.getAction() + " || " + (flatPrice * costEntity.getFactor()) + " || " + flatPrice);
                    break;

                case 3: //Especial Discount
                    if (pax >= npax && nbookings == 0){
                        paxDiscount = factor;
                    }


                    if (clientBookings >= nbookings && npax == 0) {
                        fidelityDiscount = factor;
                    }

                    break;


                default:
                    sessonPrice += flatPrice;
            }

            totalDiscount= paxDiscount + fidelityDiscount;

            InvoiceDTO invoiceDTO = new InvoiceDTO(costEntity.getDescription(), temp, costEntity.getFactor(), (flatPrice * costEntity.getFactor()));
            invoice.add(invoiceDTO);
        }
        totalPrice = eventPrice + sessonPrice;
        double finalPrice = totalPrice - (totalPrice * totalDiscount);
        System.out.println("Precio Total sin descuentos: " + totalPrice + " | Total Desc quantity: " + (totalPrice * totalDiscount) + " | Total Desc %: " +(totalDiscount * 100) + "% | Final Price: " + finalPrice);
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
