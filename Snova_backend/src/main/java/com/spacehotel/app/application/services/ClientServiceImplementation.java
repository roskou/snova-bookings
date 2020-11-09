package com.spacehotel.app.application.services;

import com.spacehotel.app.application.domain.entities.ClientEntity;
import com.spacehotel.app.application.domain.repositories.ClientRepository;
import com.spacehotel.app.application.factories.ClientFactory;
import com.spacehotel.app.application.models.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//--- Service ----------------------------------------------------------
@Service
public class ClientServiceImplementation implements ClientService {


    // Repositories & Factories needed ------------------------------
    ClientRepository repository;
    ClientFactory factory;

    // Constructor --------------------------------------------------
    @Autowired
    public ClientServiceImplementation(ClientRepository repository, ClientFactory factory) {

        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public ClientModel showClientByID(long id) {
        ClientEntity clientEntity = repository.findById(id);
        ClientModel clientModel = factory.clienteEntity2Model(clientEntity);
        return clientModel;
    }


    public ClientModel showClientByEmail(String email) {
        ClientEntity clientEntity = repository.findByEmail(email);
        ClientModel clientModel = factory.clienteEntity2Model(clientEntity);
        return clientModel;
    }
}