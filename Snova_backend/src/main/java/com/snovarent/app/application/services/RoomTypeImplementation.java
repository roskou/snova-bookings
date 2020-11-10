package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.entities.RoomTypeEntity;
import com.snovarent.app.application.domain.repositories.RoomTypeRepository;
import com.snovarent.app.application.factories.RoomTypeFactory;
import com.snovarent.app.application.models.RoomTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeImplementation implements RoomTypeService {

    //Repositories & Factories needed ------------------------------
    RoomTypeRepository repository;
    RoomTypeFactory factory;

    //Constructor --------------------------------------------------
    @Autowired
    public RoomTypeImplementation(RoomTypeRepository repository, RoomTypeFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }


    @Override
    public List<RoomTypeModel> tiposHabitacion() {
        List<RoomTypeEntity> entities = repository.findAll();
        List<RoomTypeModel> models = factory.tipoListEntity2Model(entities);
        return models;

    }
}
