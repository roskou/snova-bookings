package com.snovarent.app.application.services;

import com.snovarent.app.application.models.ClientModel;

public interface ClientService {
    ClientModel showClientByID(long id);
    ClientModel showClientByEmail(String email);
}
