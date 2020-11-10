package com.snovarent.app.application.services;

import java.sql.Date;

public interface CostService {

    long CalculateCost(Date date1, long days);
    double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight);
    String cuponGenerator();
}
