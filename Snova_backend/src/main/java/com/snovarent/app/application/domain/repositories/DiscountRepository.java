package com.snovarent.app.application.domain.repositories;

import com.snovarent.app.application.domain.entities.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {

//    @Query(value = "select c.starDate, c.endDate, c.description  from DiscountEntity c where  " +
//            "c.starDate between :checkIn and :checkOut or c.endDate between :checkOut and :checkIn")
//
//    List<Object[]> test(@Param("checkIn") String checkIn, @Param("checkOut") String checkOut);

}
//    List<Object> test(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut);