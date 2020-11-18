package com.snovarent.app.services;


import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.services.InvoiceCalcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
public class CostServiceTest {


    @Autowired
    private InvoiceCalcService invoiceCalcService;


         @Test //Testing Dates: chargeIn < chargeOut < checkIn  < checkOut
         public void Return0DAYChargeOrOffer() throws Exception {
            Date checkIn = Date.valueOf("2021-05-01");
            Date checkOut = Date.valueOf("2021-05-31");
            Date chargeIn = Date.valueOf("2021-05-31");
            Date chargeOut = Date.valueOf("2021-06-01");
            assertEquals(0, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
    }

        @Test //Testing Dates: chargeIn == checkIn  == checkOut < chargeOut
        public void Return1DAYChargeOrOffer() throws Exception {
            Date checkIn =  Date.valueOf("2021-05-01");
            Date checkOut =  Date.valueOf("2021-05-02");
            Date chargeIn = Date.valueOf("2021-05-01");
            Date chargeOut =  Date.valueOf("2021-05-10");
            assertEquals(1, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
        }

         @Test //Testing Dates: --Testing: checkIn =< chargeIn < checkOut < chargeOut
         public void Return6DAYChargeOrOffer() throws Exception {
            Date checkIn =  Date.valueOf("2021-05-01");
            Date checkOut =  Date.valueOf("2021-05-08");
            Date chargeIn = Date.valueOf("2021-05-02");
            Date chargeOut =  Date.valueOf("2021-05-23");
            assertEquals(6, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
    }

        @Test //Testing Dates: --Testing: checkIn < chargeIn < checkOut < chargeOut
        public void Return4DAYChargeOrOffer() throws Exception {
            Date checkIn =  Date.valueOf("2021-05-01");
            Date checkOut =  Date.valueOf("2021-05-26");
            Date chargeIn = Date.valueOf("2021-05-20");
            Date chargeOut =  Date.valueOf("2021-05-24");
            assertEquals(4, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
    }


       @Test //Testing: checkIn  < checkOut < chargeIn < chargeOut
       public void Return2DAYChargeOrOffer() throws Exception {
             Date checkIn = Date.valueOf("2020-03-01");
            Date checkOut = Date.valueOf("2020-03-15");
            Date chargeIn = Date.valueOf("2020-03-13");
            Date chargeOut = Date.valueOf("2020-05-01");
            assertEquals(2, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
    }

      @Test //Testing: chargeIn < checkIn  < checkOut < chargeOut
      public void Return31DAYChargeOrOffer() throws Exception {
            Date checkIn = Date.valueOf("2020-01-01");
            Date checkOut = Date.valueOf("2020-01-31");
            Date chargeIn = Date.valueOf("2019-12-01");
            Date chargeOut = Date.valueOf("2020-02-01");
            assertEquals(30, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
    }

      @Test //Testing: checkIn =< chargeIn < chargeOut < checkOut
      public void ShouldReturn6DAYChargeOrOffer() throws Exception {
             Date checkIn = Date.valueOf("2020-01-20");
            Date chargeIn = Date.valueOf("2020-01-20");
            Date chargeOut = Date.valueOf("2020-01-25");
            Date checkOut = Date.valueOf("2020-01-26");
            assertEquals(6, invoiceCalcService.daysApplyCharges(checkIn, checkOut, chargeIn, chargeOut));
    }



    }

