package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.models.CostModel;

import java.sql.Date;
import java.util.List;

public interface CostService {


    long getDaysBetweenTwoDates(Date date1, Date date2);
    String cuponGenerator();
//    float calculateCost(CostDTO costData);
    List<CostModel> showAllDiscounts();
    long getDaysToApplyOffer(Date checkIn, Date checkOut, Date startOffer, Date endOffer);
    InvoiceDTO getInvoice(CostDTO costData);


}
