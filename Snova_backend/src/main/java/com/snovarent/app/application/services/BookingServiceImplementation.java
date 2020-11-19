package com.snovarent.app.application.services;


import com.snovarent.app.application.domain.DTO.BookingDTO;
import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.entities.BookingEntity;
import com.snovarent.app.application.domain.entities.ClientEntity;
import com.snovarent.app.application.domain.entities.RoomEntity;
import com.snovarent.app.application.domain.repositories.BookingRepository;
import com.snovarent.app.application.domain.repositories.ClientRepository;
import com.snovarent.app.application.domain.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImplementation implements BookingService {

    //--- Repositories & Factories needed ------------------------------

    BookingRepository repository;
    RoomRepository roomRepository;
    ClientRepository clientRepository;
    CostService costService;


    //--- Constructor --------------------------------------------------
    @Autowired
    public BookingServiceImplementation(BookingRepository repository, RoomRepository roomRepository, ClientRepository clientRepository,  CostService costService) {
        this.repository = repository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
        this.costService = costService;
    }

    @Override
    public void deleteBooking(long id) {
        repository.deleteById(id);
    }


    @Override
    public String saveBooking(BookingDTO dto) {
        RoomEntity roomEntity = roomRepository.findById(dto.getId_habitacion());
        ClientEntity clientEntity = clientRepository.findById(dto.cliente_id);

        CostDTO dtoCost = new CostDTO(dto.fechaIn, dto.fechaOut, dto.cliente_id, dto.id_habitacion);
        double finalPrice = costService.getInvoiceData(dtoCost).finalPrice;

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setFechaIn(dto.fechaIn);
        bookingEntity.setFechaOut(dto.fechaOut);
        bookingEntity.setClienteEntity_id(clientEntity);
        bookingEntity.setHabitacionEntity_id(roomEntity);
        bookingEntity.setPrecioTotal(finalPrice);

        repository.save(bookingEntity);
        return "OK";
    }

}