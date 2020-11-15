package com.snovarent.app.ui.controllers;


import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.models.CostModel;
import com.snovarent.app.application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CostAPIController {

    // Services & Variables used ---------------------------------------
    RoomService roomService;
    RoomTypeService roomTypeService;
    BookingService bookingService;
    DateService dateService;
    ClientService clientService;
    CostService costService;

    // Constructor -----------------------------------------------------
    @Autowired
    public CostAPIController(ClientService clientService, RoomService roomService, RoomTypeService roomTypeService, BookingService bookingService, DateService dateService, CostService costService) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.bookingService = bookingService;
        this.dateService = dateService;
        this.clientService = clientService;
        this.costService = costService;
    }

    //Calulate Cost ---------------------------------------------------------------------
    @GetMapping("/cupon")
    String cuponGenerator() {
        return costService.cuponGenerator();
    }


    @GetMapping("/discounts")
    List<CostModel> showAllDiscounts() { return costService.showAllDiscounts();
    }

    @PostMapping("/invoice")
    InvoiceDTO calculateCost(@RequestBody CostDTO costData) {
        return costService.getInvoice(costData);
    }
}

