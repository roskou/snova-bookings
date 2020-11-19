package com.snovarent.app.services;


import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;
import com.snovarent.app.application.domain.repositories.ClientRepository;
import com.snovarent.app.application.services.CostServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
public class InvoiceServiceTest {

    @Autowired
    private CostServiceImplementation costServiceImplementation;

    @MockBean
    private ClientRepository clientRepository;



    @Test
    public void ShouldNotReturnNull()
    {
        assertThat(costServiceImplementation.getBookingsOfClient(2)).isNotNull();
    }

    @Test
    public void InvoiceCheck(){
        CostDTO costdata = new CostDTO(Date.valueOf("2021-01-01"),Date.valueOf("2021-01-07"),3,1);
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        when(costServiceImplementation.getInvoice(costdata)).thenReturn(invoiceDTO);
        assertThat(invoiceDTO.getFinalPrice()).isEqualTo(1000);

    }

}
