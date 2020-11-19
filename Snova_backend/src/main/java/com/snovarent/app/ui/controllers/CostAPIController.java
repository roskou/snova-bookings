package com.snovarent.app.ui.controllers;


import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.services.CostService;
import com.snovarent.app.application.services.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CostAPIController {

    // Services & Variables used ---------------------------------------

    CostService costService;
    UtilsService utilsService;

    // Constructor -----------------------------------------------------
    @Autowired
    public CostAPIController( CostService costService, UtilsService utilsService) {

        this.costService = costService;
        this.utilsService = utilsService;
    }

    //Calulate Cost ---------------------------------------------------------------------
    @GetMapping("/cupon")
    String cuponGenerator() {
        return utilsService.cuponGenerator();
    }



    @PostMapping("/invoice")
    InvoiceDTO calculateCost(@RequestBody CostDTO costData) {
        return costService.getInvoiceData(costData);
    }
}

