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
    public InvoiceDTO getInvoice(CostDTO costData){
        List<CostEntity> appliedOffersAndDiscounts = costRepository.test(costData.preCheckIn, costData.preCheckOut);
        RoomEntity room = roomRepository.findById(costData.idRoom);
        Date start = costData.preCheckIn;
        Date end = costData.preCheckOut;
        int pax = room.getNumpersonas();
        long clientBookings = getBookingsOfClient(costData.getClient());

        return makeInvoice(start, end, clientBookings, pax, room, appliedOffersAndDiscounts);
    }

    @Override
    public InvoiceDTO makeInvoice(Date start, Date end, long clientBookings, int pax, RoomEntity room, List<CostEntity> appliedOffersAndDiscounts) {

        double defaultFlatPrice = invoiceCalcService.getDefaultFlatBookingPrice(room.getPrecio(),start,end);

        InvoiceDTO invoice = invoiceCalcService.fillInvoice( pax, clientBookings, room.getPrecio(), start, end, appliedOffersAndDiscounts, defaultFlatPrice);

        invoice.finalPrice = invoiceCalcService.calcFinalPrice(defaultFlatPrice, invoice.additionalCharges);
        return invoice;
    }


    public long getBookingsOfClient (long id){
        if (id == 0){
        return 0;
    } else{
        return bookingRepository.countByCliente_Id(id);
    }

    }

}
