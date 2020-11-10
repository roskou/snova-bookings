package com.snovarent.app.application.factories;


import com.snovarent.app.application.domain.entities.ClientEntity;
import com.snovarent.app.application.models.ClientModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientFactory {

    public ClientEntity clienteModel2Entity (ClientModel clientModel){
        ClientEntity clientEntity =
                new ClientEntity(
                        clientModel.getId (),
                        clientModel.getNombre (),
                        clientModel.getApellido (),
                        clientModel.getEmail (),
                        clientModel.getCupon ());
        return clientEntity;
    }





    public ClientModel clienteEntity2Model (ClientEntity clientEntity){
        ClientModel clientModel =
                new ClientModel(
                         clientEntity.getId (),
                         clientEntity.getNombre (),
                         clientEntity.getApellido (),
                         clientEntity.getEmail (),
                         clientEntity.getCupon()
                );
        return clientModel;
    }

    public List<ClientEntity> clienteListModel2Entity (List<ClientModel> clientModels){
        List<ClientEntity> clienteEntities = new ArrayList<>();
        for (ClientModel cliente : clientModels){
            ClientEntity clientEntity =
                    new ClientEntity(
                            cliente.getId(),
                            cliente.getNombre (),
                            cliente.getApellido (),
                            cliente.getEmail (),
                            cliente.getCupon()
            );
        }
        return clienteEntities;
    }

    public List<ClientModel> clienteListEntity2Model (List<ClientEntity> clienteEntities){
        List<ClientModel> clientModels = new ArrayList<> ();
        for (ClientEntity cliente : clienteEntities){
            ClientModel clientModel =
                    new ClientModel(
                            cliente.getId (),
                            cliente.getNombre (),
                            cliente.getApellido (),
                            cliente.getEmail (),
                            cliente.getCupon ()
                    );
        }
        return clientModels;
    }

}
