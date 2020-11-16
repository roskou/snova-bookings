package com.snovarent.app.services;

import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.domain.entities.ClientEntity;
import com.snovarent.app.application.domain.repositories.ClientRepository;
import com.snovarent.app.application.models.ClientModel;
import com.snovarent.app.application.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    public void ShouldReturnClientModelByEmail(){
        ClientEntity client = new ClientEntity(3,"Oscar", "Lara", "roskou@gmail.com","");
        when(clientRepository.findByEmail("roskou@gmail.com")).thenReturn(client);
        ClientModel model = clientService.showClientByEmail("roskou@gmail.com");

        assertThat(model.getApellido()).isEqualTo("Lara");
        assertThat(model.getId()).isEqualTo(3);
    }
}
