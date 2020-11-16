package com.snovarent.app.ui.controllers;


import com.snovarent.app.application.domain.DTO.BookingDTO;
import com.snovarent.app.application.domain.DTO.LoginDTO;
import com.snovarent.app.application.domain.DTO.ViewRoomDetailDTO;
import com.snovarent.app.application.models.ClientModel;
import com.snovarent.app.application.models.RoomModel;
import com.snovarent.app.application.models.RoomTypeModel;
import com.snovarent.app.application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RestAPIController {

    // Services & Variables used ---------------------------------------
    RoomService roomService;
    RoomTypeService roomTypeService;
    BookingService bookingService;
    DateService dateService;
    ClientService clientService;

    // Constructor -----------------------------------------------------
    @Autowired
    public RestAPIController(ClientService clientService, RoomService roomService, RoomTypeService roomTypeService, BookingService bookingService, DateService dateService) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.bookingService = bookingService;
        this.dateService = dateService;
        this.clientService = clientService;
    }

    //Rooms Mappins ---------------------------------------------------------------------
    @GetMapping("/flat")
    List<RoomModel> showAllRooms() {
        return roomService.showAllRooms();
    }

    @GetMapping("/flatAllByType/{tipo}")
    List<ViewRoomDetailDTO> showAllRoomsByType(@PathVariable("tipo") long tipo) {
        return roomService.showAllRoomsByType(tipo);
    }

    @GetMapping("/flatType")
    List<RoomTypeModel> tiposHabitacion() { return roomTypeService.tiposHabitacion(); }

    @GetMapping("/flatID/{id}")
    ViewRoomDetailDTO showHabitacionByID(@PathVariable("id") long id) {
        return new ViewRoomDetailDTO(roomService.showRoomByID(id), dateService.bookingDatesGeneratorByID(id)) ;
    }


    //Bookings Mappings-------------------------------------------------------------------


    @GetMapping("/date/{id}")
    List<Date> bookingDatesGenerator(@PathVariable("id") long id){ return dateService.bookingDatesGeneratorByID(id);};

    @DeleteMapping("/bookingnow/{id}")
    public void deleteBooking(@PathVariable long id) {
        bookingService.deleteBooking(id);
    }

    @PostMapping("/bookingnow")
    public String saveBooking(@RequestBody BookingDTO newBooking) {
        return bookingService.saveBooking(newBooking);
    }

    //Login Mappings-------------------------------------------------------------------
    @PostMapping("/login")
    public ClientModel checkEmail(@RequestBody LoginDTO login) {

        System.out.println("Login DATA:" + login.toString());

        try {
            ClientModel client = clientService.showClientByEmail(login.getEmail());
            return client;

        }catch (Throwable ex) {
           return new ClientModel();
        }

    }

}

