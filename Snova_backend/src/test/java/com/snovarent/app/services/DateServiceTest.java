package com.snovarent.app.services;

import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.domain.repositories.BookingRepository;
import com.snovarent.app.application.models.BookingModel;
import com.snovarent.app.application.models.ClientModel;
import com.snovarent.app.application.models.RoomModel;
import com.snovarent.app.application.models.RoomTypeModel;
import com.snovarent.app.application.services.DateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
public class DateServiceTest {

    @Autowired
    private DateService dateservice;
    @MockBean
    private BookingRepository bookingRepository;

    @Test
    @DisplayName("Generates Dates Between 2 Dates")
    public void generatorDatesTest() {

            BookingModel booking = new BookingModel (5, Date.valueOf("2021-01-01"), Date.valueOf("2021-01-06"), 120,
                    new ClientModel(3,"Oscar", "Lara", "roskou@gmail.com", ""),
                    new RoomModel ( 4,"El pepinillo", "No encontraras una casa mas larga y mas verde",
                            600, new RoomTypeModel(1, "Wild Nature", "Maravillosa habitación standar con vistas Increibles"), 1, 40, "MALAGA")
            );

            List<Date[]> Bookdates = new ArrayList();
            Date bookDate[] = new Date[2];
            bookDate[0] = booking.getFechaIn ();
            bookDate[1] = booking.getFechaOut();
            Bookdates.add(bookDate);
            List<Date>  days = new ArrayList ();
            days.add (Date.valueOf ("2021-01-01"));
            days.add (Date.valueOf ("2021-01-02"));
            days.add (Date.valueOf ("2021-01-03"));
            days.add (Date.valueOf ("2021-01-04"));
            days.add (Date.valueOf ("2021-01-05"));
            when(bookingRepository.dateBookingsByRoom (5)).thenReturn (Bookdates);
            List<Date> result = dateservice.bookingDatesGeneratorByID(booking.getId ());
            assertEquals(days, result);
        }

    @Test
    public void GetDaysBetween2DatesShouldReturn30Days() throws Exception {
        Date starDate = (Date.valueOf("2021-05-01"));
        Date endDate = (Date.valueOf("2021-05-31"));
        assertEquals(30, dateservice.getDaysBetweenTwoDates(starDate, endDate));
    }

    @Test
    public void GetDaysBetween2DatesShouldReturn365Days() throws Exception {
        Date starDate = (Date.valueOf("2022-01-01"));
        Date endDate = (Date.valueOf("2023-01-01"));
        assertEquals(365, dateservice.getDaysBetweenTwoDates(starDate,endDate));
    }

}



