package com.snovarent.app.application.factories;


import com.snovarent.app.application.domain.entities.RoomEntity;
import com.snovarent.app.application.models.RoomModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomFactory {
    RoomTypeFactory roomTypeFactory = new RoomTypeFactory();

    public RoomEntity habitacionModel2Entity (RoomModel roomModel){
        RoomEntity roomEntity =
                new RoomEntity(
                        roomModel.getId (),
                        roomModel.getCodigo (),
                        roomModel.getDescripcion (),
                        roomModel.getPrecio (),
                        roomTypeFactory.tipoModel2Entity(roomModel.getTipoModel ()),
                        roomModel.getNumpersonas(),
                        roomModel.getM2(),
                        roomModel.getLocalidad()
                );
        return roomEntity;
    }

    public RoomModel habitacionEntity2Model (RoomEntity roomEntity){
        RoomModel roomModel =
                new RoomModel(
                        roomEntity.getId (),
                        roomEntity.getCodigo (),
                        roomEntity.getDescripcion (),
                        roomEntity.getPrecio (),
                        roomTypeFactory.tipoEntity2Model(roomEntity.getTipo ()),
                        roomEntity.getNumpersonas(),
                        roomEntity.getM2(),
                        roomEntity.getLocalidad()
                );
        return roomModel;
    }

    public List<RoomModel> habitacionListEntity2Model(List<RoomEntity> habitacionEntities){
        List<RoomModel> roomModels = new ArrayList<> ();
        for (RoomEntity habitacion : habitacionEntities){
            RoomModel roomModel =
                    new RoomModel(
                            habitacion.getId (),
                            habitacion.getCodigo (),
                            habitacion.getDescripcion (),
                            habitacion.getPrecio (),
                            roomTypeFactory.tipoEntity2Model (habitacion.getTipo ()),
                            habitacion.getNumpersonas(),
                            habitacion.getM2(),
                            habitacion.getLocalidad()
                    );
            roomModels.add (roomModel);
        }
        return roomModels;
    }

}
