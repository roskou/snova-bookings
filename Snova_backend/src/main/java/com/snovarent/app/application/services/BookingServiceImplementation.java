package com.snovarent.app.application.services;


import com.snovarent.app.application.domain.entities.BookingEntity;
import com.snovarent.app.application.factories.BookingFactory;
import com.snovarent.app.application.domain.repositories.BookingRepository;
import com.snovarent.app.application.models.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BookingServiceImplementation implements BookingService {

    //--- Repositories & Factories needed ------------------------------

    BookingRepository repository;
    BookingFactory factory;



    //--- Constructor --------------------------------------------------
    @Autowired
    public BookingServiceImplementation(BookingRepository repository, BookingFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public List<BookingModel> showBookings() {
        List<BookingEntity> entities = repository.findAll();
        List<BookingModel> models = factory.reservaListEntity2Model(entities);
        return models;
    }

    @Override
    public void deleteBooking(long id) {
        repository.deleteById(id);
    }


    @Override
    public void saveBooking(BookingModel model) {
        repository.save(factory.reservaModel2Entity(model));
        return;
    }

}