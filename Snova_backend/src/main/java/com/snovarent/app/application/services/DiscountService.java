package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.models.DiscountModel;

import java.sql.Date;
import java.util.List;

public interface DiscountService {


    long getDaysBetweenTwoDates(Date date1, Date date2);
    String cuponGenerator();
    float calculateCost(CostDTO costData);
    List<DiscountModel> showAllDiscounts();
}
