package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DateServiceImplementation implements DateService {

    DateTimeFormatter formatoDeEntrada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatoDeSalida = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //Repositories & Factories needed ------------------------------

    BookingRepository repository;

    //Functions ------------------------------------------------------
    @Autowired
    public DateServiceImplementation(BookingRepository repository) {
        this.repository = repository;
    }


//    @Override
//    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
//        long nights = getDaysBetweenTwoDates(checkIn, checkOut);
//        double totalPrice = nights * pricePerNight;
//        return totalPrice;
//    }

    @Override
    public Date stringToDate(String date) {
        return Date.valueOf( LocalDate.parse(date, formatoDeEntrada).format(formatoDeSalida) );
    }

//    @Override
//    public long getDaysBetweenTwoDates(Date date1, Date date2) {
//        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);
//    }

    @Override
    public List<Date> bookingDatesGeneratorByID(long id) {
        List<Date[]> dateRange = repository.dateBookingsByRoom(id);
        List<Date> generatedDates = new ArrayList<>();

        System.out.println("---------------------------------");
        for (int i = 0; i < dateRange.size(); i++) {

            Date start = dateRange.get(i)[0];
            Date end = dateRange.get(i)[1];
            while (!start.equals(end)) {
                generatedDates.add(start);
                start = new Date(start.getTime() + TimeUnit.DAYS.toMillis( 1 ));
            }
            for (int x = 0; x < dateRange.size(); x++) {
                System.out.println("Fechas: " + dateRange.get(x));
            }
            System.out.println("---------------------------------");
        }

        return generatedDates;
    }


}