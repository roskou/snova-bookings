package com.snovarent.app.services;


import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.services.CostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
public class CostServiceTest {

    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private CostService costService;


         @Test //Testing Dates: chargeIn < chargeOut < checkIn  < checkOut
         public void Return0DAYChargeOrOffer() throws Exception {
            Date checkIn = Date.valueOf("2021-05-01");
            Date checkOut = Date.valueOf("2021-05-31");
            Date offerIn = Date.valueOf("2021-05-31");
            Date offerOut = Date.valueOf("2021-06-01");
            assertEquals(0, costService.daysApplyCharges(checkIn, checkOut, offerIn, offerOut));
    }

        @Test //Testing Dates: offerIn == checkIn  == checkOut < chargeOut
        public void Return1DAYChargeOrOffer() throws Exception {
            Date checkIn =  Date.valueOf("2021-05-01");
            Date checkOut =  Date.valueOf("2021-05-02");
            Date offerIn = Date.valueOf("2021-05-01");
            Date offerOut =  Date.valueOf("2021-05-10");
            assertEquals(1, costService.daysApplyCharges(checkIn, checkOut, offerIn, offerOut));
        }

         @Test //Testing Dates: //Testing: checkIn =< chargeIn < checkOut < chargeOut
         public void Return6DAYChargeOrOffer() throws Exception {
            Date checkIn =  Date.valueOf("2021-05-01");
            Date checkOut =  Date.valueOf("2021-05-08");
            Date offerIn = Date.valueOf("2021-05-02");
            Date offerOut =  Date.valueOf("2021-05-23");
            assertEquals(6, costService.daysApplyCharges(checkIn, checkOut, offerIn, offerOut));
    }

        @Test //Testing Dates: //Testing: checkIn < offerIn < checkOut < offerOut
        public void Return4DAYChargeOrOffer() throws Exception {
            Date checkIn =  Date.valueOf("2021-05-01");
            Date checkOut =  Date.valueOf("2021-05-26");
            Date offerIn = Date.valueOf("2021-05-20");
            Date offerOut =  Date.valueOf("2021-05-24");
            assertEquals(4, costService.daysApplyCharges(checkIn, checkOut, offerIn, offerOut));
    }




    }

