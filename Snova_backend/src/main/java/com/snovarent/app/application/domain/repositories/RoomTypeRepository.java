package com.spacehotel.app.application.domain.repositories;

import com.spacehotel.app.application.domain.entities.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Long> {

}
