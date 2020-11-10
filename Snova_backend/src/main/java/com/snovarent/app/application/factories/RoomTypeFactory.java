package com.snovarent.app.application.factories;


import com.snovarent.app.application.domain.entities.RoomTypeEntity;
import com.snovarent.app.application.models.RoomTypeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomTypeFactory {

    public RoomTypeEntity tipoModel2Entity (RoomTypeModel roomTypeModel){
        RoomTypeEntity roomTypeEntity = new RoomTypeEntity(
                roomTypeModel.getId (),
                roomTypeModel.getNombre (),
                roomTypeModel.getDescripcion ()
        );
        return roomTypeEntity;
    }


    public RoomTypeModel tipoEntity2Model (RoomTypeEntity roomTypeEntity){
        RoomTypeModel roomTypeModel = new RoomTypeModel(
                roomTypeEntity.getId (),
                roomTypeEntity.getNombre (),
                roomTypeEntity.getDescripcion ()
        );
        return roomTypeModel;
    }


    public List<RoomTypeEntity> tipoListModel2Entity (List<RoomTypeModel> roomTypeModels){
        List<RoomTypeEntity> tipoEntities = new ArrayList<> ();
        for (RoomTypeModel tipo : roomTypeModels){
            RoomTypeEntity roomTypeEntity =
                    new RoomTypeEntity(
                            tipo.getId (),
                            tipo.getNombre (),
                            tipo.getDescripcion ()
                    );
            tipoEntities.add (roomTypeEntity);
        }
        return tipoEntities;
    }

    public List<RoomTypeModel> tipoListEntity2Model (List<RoomTypeEntity> tipoEntities){
        List<RoomTypeModel> roomTypeModels = new ArrayList<> ();
        for (RoomTypeEntity tipo : tipoEntities){
            RoomTypeModel roomTypeModel =
                    new RoomTypeModel(
                            tipo.getId (),
                            tipo.getNombre (),
                            tipo.getDescripcion ()
                    );
            roomTypeModels.add (roomTypeModel);
        }
        return roomTypeModels;
    }
}
