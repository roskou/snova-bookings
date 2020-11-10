package com.spacehotel.app.application.services;

import com.spacehotel.app.application.models.BookingModel;

import java.util.List;

public interface BookingService {

    void deleteBooking(long id);
    void saveBooking(BookingModel bookingModel);
    List<BookingModel> showBookings();
}
