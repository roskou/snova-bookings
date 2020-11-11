package com.snovarent.app.application.services;

import java.sql.Date;
import java.util.List;

public interface DateService {
//    double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight);
    Date stringToDate(String date);
//    long getDaysBetweenTwoDates(Date date1, Date date2);
    List<Date> bookingDatesGeneratorByID(long id);
}
