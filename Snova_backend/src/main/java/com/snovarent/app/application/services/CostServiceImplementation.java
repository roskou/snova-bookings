package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

//TODO Calculo de coste de reserva.
// * sabado y domingo 15% mas caro
// * Apartir de 7 dias 10% de descuento

@Service
public class CostServiceImplementation implements CostService {

//    public long CalculateCost(Date fechaIn, Date fechaOut, double precio, long days){
//        Calendar c = Calendar.getInstance();
//        c.setTime(fechaIn);
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//
//
//        return dayOfWeek;
//    }

    @Override
    public String calculateCost(CostDTO costData) {


        return null;
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

//    @Override
//    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
//        long nights = DateService.getDaysBetweenTwoDates(checkIn, checkOut);
//        double totalPrice = nights * pricePerNight;
//        return totalPrice;
//    }

}
