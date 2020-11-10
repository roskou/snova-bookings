package com.spacehotel.app.application.factories;


import com.spacehotel.app.application.domain.entities.BookingEntity;
import com.spacehotel.app.application.models.BookingModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingFactory {
    ClientFactory clientFactory = new ClientFactory();
    RoomFactory roomFactory = new RoomFactory();


    public BookingEntity reservaModel2Entity (BookingModel bookingModel){
        BookingEntity bookingEntity =
                new BookingEntity(
                        bookingModel.getId (),
                        bookingModel.getFechaIn (),
                        bookingModel.getFechaOut (),
                        bookingModel.getPrecioTotal (),
                        clientFactory.clienteModel2Entity (bookingModel.getCliente ()),
                        roomFactory.habitacionModel2Entity (bookingModel.getHabitacion ())
                        );
        return bookingEntity;
    }

    public BookingModel reservaEntity2Model (BookingEntity bookingEntity){
        BookingModel bookingModel =
                new BookingModel(
                        bookingEntity.getId (),
                        bookingEntity.getFechaIn (),
                        bookingEntity.getFechaOut (),
                        bookingEntity.getPrecioTotal (),
                        clientFactory.clienteEntity2Model (bookingEntity.getClienteEntity_id ()),
                        roomFactory.habitacionEntity2Model (bookingEntity.getHabitacion ())
                );
        return bookingModel;
    }



    public List<BookingModel> reservaListEntity2Model(List<BookingEntity> reservaEntities){
        List<BookingModel> bookingModels = new ArrayList<> ();
        for (BookingEntity reserva : reservaEntities){
            BookingModel bookingModel =
                    new BookingModel(
                            reserva.getId (),
                            reserva.getFechaIn (),
                            reserva.getFechaOut (),
                            reserva.getPrecioTotal (),
                            clientFactory.clienteEntity2Model (reserva.getClienteEntity_id ()),
                            roomFactory.habitacionEntity2Model(reserva.getHabitacion())
                    );
            bookingModels.add (bookingModel);
        }
        return bookingModels;
    }
}
