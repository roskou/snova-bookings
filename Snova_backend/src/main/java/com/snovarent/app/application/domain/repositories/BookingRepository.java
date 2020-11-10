package com.snovarent.app.application.domain.repositories;

import com.snovarent.app.application.domain.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {


 @Query(value = "select e.fechaIn, e.fechaOut  from BookingEntity e where  (e.fechaOut > current_date) AND (e.habitacion.id = :id)")
 List<Date[]> dateBookingsByRoom(@Param("id") long id);
}
