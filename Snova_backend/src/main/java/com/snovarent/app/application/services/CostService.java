package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;

public interface CostService {



    String cuponGenerator();
    String calculateCost(CostDTO costData);
}
