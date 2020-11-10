package com.snovarent.app.application.domain.repositories;

import com.snovarent.app.application.domain.entities.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<CostEntity, Long> {
}
