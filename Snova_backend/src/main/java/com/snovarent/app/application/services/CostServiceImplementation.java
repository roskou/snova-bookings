package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.entities.CostEntity;
import com.snovarent.app.application.domain.entities.RoomEntity;
import com.snovarent.app.application.domain.repositories.BookingRepository;
import com.snovarent.app.application.domain.repositories.CostRepository;
import com.snovarent.app.application.domain.repositories.RoomRepository;
import com.snovarent.app.application.factories.CostFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class CostServiceImplementation implements CostService {


    // Repositories, Services & Factories needed ------------------------------
    CostRepository costRepository;
    RoomRepository roomRepository;
    BookingRepository bookingRepository;
    CostFactory factory;
    DateService dateService;
    InvoiceCalcService invoiceCalcService;

    // Constructor --------------------------------------------------
    @Autowired
    public CostServiceImplementation(CostRepository costRepository, RoomRepository roomRepository, CostFactory factory, BookingRepository bookingRepository, DateService dateService, InvoiceCalcService invoiceCalcService) {
        this.costRepository = costRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.factory = factory;
        this.dateService = dateService;
        this.invoiceCalcService = invoiceCalcService;
    }




    @Override
    public InvoiceDTO getInvoice(CostDTO costData) {

        List<CostEntity> costEntities = costRepository.test(costData.preCheckIn, costData.preCheckOut);
        RoomEntity roomEntity = roomRepository.findById(costData.idRoom);

        int pax = roomEntity.getNumpersonas();
        long clientBookings = getBookingsOfClient(costData.getClient());


        Date start = costData.preCheckIn;
        Date end = costData.preCheckOut;

        double defaultFlatPrice = invoiceCalcService.getDefaultFlatBookingPrice(roomEntity.getPrecio(),start,end);

        InvoiceDTO pepe = invoiceCalcService.fillInvoice( pax, clientBookings, roomEntity.getPrecio(), start, end, costEntities, defaultFlatPrice);

        pepe.finalPrice = invoiceCalcService.calcFinalPrice(defaultFlatPrice, pepe.additionalCharges);
        return pepe;
    }


    public long getBookingsOfClient (long id){
        if (id == 0){
        return 0;
    } else{
        return bookingRepository.countByCliente_Id(id);
    }

    }

}
