package com.spacehotel.app.ui.controllers;


import com.spacehotel.app.application.domain.DTO.BookingDTO;
import com.spacehotel.app.application.domain.DTO.LoginDTO;
import com.spacehotel.app.application.domain.DTO.ViewRoomDetailDTO;
import com.spacehotel.app.application.models.BookingModel;
import com.spacehotel.app.application.models.ClientModel;
import com.spacehotel.app.application.models.RoomModel;
import com.spacehotel.app.application.models.RoomTypeModel;
import com.spacehotel.app.application.services.*;
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

    //Rooms ---------------------------------------------------------------------
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


    //Bookings-------------------------------------------------------------------

    @GetMapping("/bookingnow")
    List<BookingModel> showBookings() { return bookingService.showBookings();
    }

    @GetMapping("/date/{id}")
    List<Date> bookingDatesGenerator(@PathVariable("id") long id){ return dateService.bookingDatesGeneratorByID(id);};

    @DeleteMapping("/bookingnow/{id}")
    public void deleteBooking(@PathVariable long id) {
        bookingService.deleteBooking(id);
    }

    @PostMapping("/bookingnow")
    public void saveBooking(@RequestBody BookingDTO newBooking) {
        System.out.println(newBooking.toString());
        RoomModel roomModel = roomService.showRoomByID(newBooking.getId_habitacion());
        System.out.println("\n *** ROOM MODEL ***" + roomModel.toString());
        ClientModel clientModel = clientService.showClientByID(newBooking.getCliente_id());
        System.out.println("\n *** CLIENTE MODEL *** " + clientModel.toString());
        BookingModel bookingModel = new BookingModel(newBooking.getFechaIn(), newBooking.getFechaOut(), newBooking.getPrecioTotal(), clientModel, roomModel );
        System.out.println("\n *** RESERVA MODEL *** " + bookingModel.toString());
    }

//    @PostMapping("/login")
//    public String checkEmail(@RequestBody BookingDTO newBooking) {
//        String validation="";
//        return validation; // esto me devuelve el response al front (objeto)
//    }

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

