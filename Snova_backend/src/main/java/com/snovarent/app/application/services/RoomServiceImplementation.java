package com.spacehotel.app.application.services;


import com.spacehotel.app.application.domain.DTO.ViewRoomDetailDTO;
import com.spacehotel.app.application.domain.entities.RoomEntity;
import com.spacehotel.app.application.domain.repositories.RoomRepository;
import com.spacehotel.app.application.factories.RoomFactory;
import com.spacehotel.app.application.models.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//--- Service ----------------------------------------------------------
    @Service
    public class RoomServiceImplementation implements RoomService {

    private final DateService dateservice;
    // Repositories & Factories needed ------------------------------
    RoomRepository repository;
    RoomFactory factory;

    // Constructor --------------------------------------------------
    @Autowired
    public RoomServiceImplementation(RoomRepository repository, RoomFactory factory, DateService dateService) {
        this.repository = repository;
        this.factory = factory;
        this.dateservice = dateService;
    }

    // Functions-----------------------------------------------------


    @Override
    public List<RoomModel> showAllRooms() {
        List<RoomEntity> entities = repository.findAll();
        List<RoomModel> models = factory.habitacionListEntity2Model(entities);
        return models;
    }

    @Override
    public List<ViewRoomDetailDTO> showAllRoomsByType(long tipo) {
        List<RoomEntity> entities = repository.findByTipoId(tipo);
        List<RoomModel> models = factory.habitacionListEntity2Model(entities);
        List<ViewRoomDetailDTO> viewRoomDetailDTO = new ArrayList<>();
        for (RoomModel roomModel : models){
            ViewRoomDetailDTO view =
                    new ViewRoomDetailDTO(roomModel, this.dateservice.bookingDatesGeneratorByID(roomModel.getId())
            );
            viewRoomDetailDTO.add(view);
        }
        return viewRoomDetailDTO;
    }



    @Override
    public List<RoomModel> showRoomByGuest(int numGuest) {
        return null;
    }


    @Override
    public RoomModel showRoomByID(long id) {

        RoomEntity roomEntity = repository.findById(id);
        RoomModel roomModel = factory.habitacionEntity2Model(roomEntity);
        return roomModel;
    }
}