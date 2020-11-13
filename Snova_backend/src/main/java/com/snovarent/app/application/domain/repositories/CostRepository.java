package com.snovarent.app.application.domain.repositories;

import com.snovarent.app.application.domain.entities.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<CostEntity, Long> {

    @Query(value = "select c from CostEntity c where  " +
            "(:checkIn between c.starDate and c.endDate) or (:checkOut between  c.starDate and c.endDate)")
    List<CostEntity> test(@Param("checkIn") Date checkIn , @Param("checkOut") Date checkOut);

}
