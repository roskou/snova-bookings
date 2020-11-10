package com.spacehotel.app.application.services;

import com.spacehotel.app.application.domain.entities.RoomTypeEntity;
import com.spacehotel.app.application.domain.repositories.RoomTypeRepository;
import com.spacehotel.app.application.factories.RoomTypeFactory;
import com.spacehotel.app.application.models.RoomTypeModel;
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
