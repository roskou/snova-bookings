package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.DTO.InvoiceRowDTO;
import com.snovarent.app.application.domain.entities.CostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class InvoiceCalcServiceImplementation implements InvoiceCalcService{
    DateService dateService;

    // Constructor --------------------------------------------------
    @Autowired
    public InvoiceCalcServiceImplementation(DateService dateService) {

        this.dateService = dateService;
    }


    @Override
    public double getDefaultFlatBookingPrice(double pricePerNight, Date start, Date end ){
        long nights = dateService.getDaysBetweenTwoDates(start, end);
        System.out.println("+++++++++ nights:" + nights + "pricePerNight:" + pricePerNight);
        return pricePerNight * nights;
    }

    @Override
    public InvoiceDTO fillInvoice(int pax, long clientBookings, double pricePerNight, Date start, Date end, List<CostEntity> costEntities, double defaultFlatPrice) {
        long nights = dateService.getDaysBetweenTwoDates(start, end);

        InvoiceDTO invoice = new InvoiceDTO();
        invoice.invoiceRows.add(new InvoiceRowDTO("Default Price", nights, defaultFlatPrice));
        System.out.println("+++++++++ nights:" + nights + "pricePerNight:" + defaultFlatPrice);


        double additionalCharges = 0;

        for (CostEntity costEntity : costEntities) {
            long daysToApplyDiscount = daysApplyCharges(start, end, costEntity.getStarDate(), costEntity.getEndDate()); //definimos cuantos dias hay para cada tipo de negocio
            double currentCharges = 0;


            if (costEntity.getAction() == 3) {
                int npaxdiscount = costEntity.getNpax();
                int nbookings = costEntity.getNbookings();

                if ((pax >= npaxdiscount && nbookings == 0) || (clientBookings >= nbookings && npaxdiscount == 0)) {
                    currentCharges = pricePerNight * costEntity.getFactor() * daysToApplyDiscount;
                    invoice.invoiceRows.add(new InvoiceRowDTO(costEntity.getDescription(), daysToApplyDiscount, currentCharges));
                }
            } else {
                currentCharges = pricePerNight * costEntity.getFactor() * daysToApplyDiscount;
                invoice.invoiceRows.add(new InvoiceRowDTO(costEntity.getDescription(), daysToApplyDiscount, currentCharges));
            }
            additionalCharges += currentCharges;
        }

            invoice.additionalCharges= additionalCharges;

        return invoice;
    }

    public double calcFinalPrice(double defaultFlatPrice, double additionalCharges){
        return defaultFlatPrice + additionalCharges;
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
}
