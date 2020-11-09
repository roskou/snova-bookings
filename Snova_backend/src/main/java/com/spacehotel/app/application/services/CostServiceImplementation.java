package com.spacehotel.app.application.services;

import java.sql.Date;
import java.util.Calendar;

//TODO Calculo de coste de reserva.
// * sabado y domingo 15% mas caro
// * Apartir de 7 dias 10% de descuento

public class CostServiceImplementation implements CostService {

    public long CalculateCost(Date fechaIn, Date fechaOut, double precio, long days){
        Calendar c = Calendar.getInstance();
        c.setTime(fechaIn);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);


        return dayOfWeek;
    }

    @Override
    public long CalculateCost(Date date1, long days) {
        return 0;
    }

    @Override
    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
        return 0;
    }

//    @Override
//    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
//        long nights = DateService.getDaysBetweenTwoDates(checkIn, checkOut);
//        double totalPrice = nights * pricePerNight;
//        return totalPrice;
//    }

}
