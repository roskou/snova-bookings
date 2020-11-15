package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.BookingDTO;

public interface BookingService {

    void deleteBooking(long id);
    String saveBooking(BookingDTO dto);
}
