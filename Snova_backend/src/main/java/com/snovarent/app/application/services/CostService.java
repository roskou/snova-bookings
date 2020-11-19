package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.entities.CostEntity;
import com.snovarent.app.application.domain.entities.RoomEntity;

import java.sql.Date;
import java.util.List;

public interface CostService {



    InvoiceDTO getInvoice(CostDTO costData);

    InvoiceDTO makeInvoice(Date start, Date end, long clientBookings, int pax, RoomEntity room, List<CostEntity> appliedOffersAndDiscounts);


}
