package com.snovarent.app.services;


import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.entities.CostEntity;
import com.snovarent.app.application.domain.entities.RoomEntity;
import com.snovarent.app.application.domain.entities.RoomTypeEntity;
import com.snovarent.app.application.services.CostServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
public class InvoiceServiceTest {

    @Autowired
    private CostServiceImplementation costServiceImplementation;



    @Test
    public void ShouldNotReturnNull()
    {
        assertThat(costServiceImplementation.getBookingsOfClient(2)).isNotNull();
    }

    @Test
    public void InvoiceCheckGeneralDiscounts(){

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        List<CostEntity> appliedOffersAndDiscounts = new ArrayList<>();

        appliedOffersAndDiscounts.add(new CostEntity (1, Date.valueOf("2021-01-04"), Date.valueOf("2021-10-01"),"Temporada de Frio", 0, 0, 1, 0,  0.2));

        RoomTypeEntity type = new RoomTypeEntity(1,"SpaceFlat","Una casa que Flota");
        RoomEntity room = new RoomEntity(1,"La Casa de Chocolate","Una Casa para comersela",100,type,4,100,"BARCELONA");
        Date start = Date.valueOf("2021-01-01");
        Date end = Date.valueOf("2021-01-02");
        long clientBookings = 1;
        int pax = 4;
        assertThat(costServiceImplementation.makeInvoice(start, end, clientBookings, pax, room, appliedOffersAndDiscounts).getFinalPrice())
                .isEqualTo(120);
        assertThat(costServiceImplementation.makeInvoice(start, end, clientBookings, pax, room, appliedOffersAndDiscounts).getAdditionalCharges())
                .isEqualTo(20);



    }

    @Test
    public void InvoiceCheckGeneralFidelityDiscounts(){

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        List<CostEntity> appliedOffersAndDiscounts = new ArrayList<>();

        appliedOffersAndDiscounts.add(new CostEntity (1, Date.valueOf("2021-01-04"), Date.valueOf("2021-10-01"),"Descuento fidelidad", 0, 0, 3, 0,  0.2));

        RoomTypeEntity type = new RoomTypeEntity(1,"SpaceFlat","Una casa que Flota");
        RoomEntity room = new RoomEntity(1,"La Casa de Chocolate","Una Casa para comersela",100,type,4,100,"BARCELONA");
        Date start = Date.valueOf("2021-01-01");
        Date end = Date.valueOf("2021-01-02");
        long clientBookings = 4;
        int pax = 4;
        assertThat(costServiceImplementation.makeInvoice(start, end, clientBookings, pax, room, appliedOffersAndDiscounts).getFinalPrice())
                .isEqualTo(120);
        assertThat(costServiceImplementation.makeInvoice(start, end, clientBookings, pax, room, appliedOffersAndDiscounts).getAdditionalCharges())
                .isEqualTo(20);



    }

}
