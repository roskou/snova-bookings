package com.snovarent.app.ui.controllers;


import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.models.DiscountModel;
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
    DiscountService discountService;

    // Constructor -----------------------------------------------------
    @Autowired
    public CostAPIController(ClientService clientService, RoomService roomService, RoomTypeService roomTypeService, BookingService bookingService, DateService dateService, DiscountService discountService) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.bookingService = bookingService;
        this.dateService = dateService;
        this.clientService = clientService;
        this.discountService = discountService;
    }

    //Calulate Cost ---------------------------------------------------------------------
    @GetMapping("/cupon")
    String cuponGenerator() {
        return discountService.cuponGenerator();
    }



    @GetMapping("/discounts")
    List<DiscountModel> showAllDiscounts() { return discountService.showAllDiscounts();
    }

//    @GetMapping("/flatAllByType/{tipo}")
//    List<ViewRoomDetailDTO> showAllRoomsByType(@PathVariable("tipo") long tipo) {
//        return roomService.showAllRoomsByType(tipo);
//    }
//
//    @GetMapping("/flatType")
//    List<RoomTypeModel> tiposHabitacion() { return roomTypeService.tiposHabitacion(); }
//
//    @GetMapping("/flatID/{id}")
//    ViewRoomDetailDTO showHabitacionByID(@PathVariable("id") long id) {
//        return new ViewRoomDetailDTO(roomService.showRoomByID(id), dateService.bookingDatesGeneratorByID(id)) ;
//    }
//
//
//    //Bookings Mappings-------------------------------------------------------------------
//
//    @GetMapping("/bookingnow")
//    List<BookingModel> showBookings() { return bookingService.showBookings();
//    }
//
//    @GetMapping("/date/{id}")
//    List<Date> bookingDatesGenerator(@PathVariable("id") long id){ return dateService.bookingDatesGeneratorByID(id);};
//
//    @DeleteMapping("/bookingnow/{id}")
//    public void deleteBooking(@PathVariable long id) {
//        bookingService.deleteBooking(id);
//    }
//
//    @PostMapping("/bookingnow")
//    public void saveBooking(@RequestBody BookingDTO newBooking) {
//        System.out.println(newBooking.toString());
//        RoomModel roomModel = roomService.showRoomByID(newBooking.getId_habitacion());
//        System.out.println("\n *** ROOM MODEL ***" + roomModel.toString());
//        ClientModel clientModel = clientService.showClientByID(newBooking.getCliente_id());
//        System.out.println("\n *** CLIENTE MODEL *** " + clientModel.toString());
//        BookingModel bookingModel = new BookingModel(newBooking.getFechaIn(), newBooking.getFechaOut(), newBooking.getPrecioTotal(), clientModel, roomModel );
//        System.out.println("\n *** RESERVA MODEL *** " + bookingModel.toString());
//    }
//    //Cost Mappings--------------------------------------------------------------------
//
//
//
//
//
//    //Login Mappings-------------------------------------------------------------------
//    @PostMapping("/login")
//    public ClientModel checkEmail(@RequestBody LoginDTO login) {
//
//        System.out.println("Login DATA:" + login.toString());
//
//        try {
//            ClientModel client = clientService.showClientByEmail(login.getEmail());
//            return client;
//
//        }catch (Throwable ex) {
//           return new ClientModel();
//        }
//
//    }

    @PostMapping("/cost")
    float calculateCost(@RequestBody CostDTO costData) {

        System.out.println("********* Cost DATA:" + costData.toString());


        System.out.println("*/*/*/*/*/");
        float cost = discountService.calculateCost(costData);
        System.out.println("*/*/*/*/*/" + cost);
        return cost;


    }

}

