package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.entities.CostEntity;

import java.sql.Date;
import java.util.List;

public interface InvoiceCalcService {


    double calcFinalPrice(double defaultFlatPrice, double additionalCharges);
    double getDefaultFlatBookingPrice(double pricePerNight, Date start, Date end );
    InvoiceDTO fillInvoice(int pax, long clientBookings, double pricePerNight, Date start, Date end, List<CostEntity> costEntities, double defaultPrice);
    long daysApplyCharges(Date checkIn, Date checkOut, Date startDateDiscount, Date endDateDiscount);
}
