package com.spacehotel.app.application.services;

import com.spacehotel.app.application.models.ClientModel;

public interface ClientService {
    ClientModel showClientByID(long id);
    ClientModel showClientByEmail(String email);
}
