package com.spacehotel.app.application.domain.repositories;

import com.spacehotel.app.application.domain.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    List<RoomEntity> findByTipoId(long tipo);
    RoomEntity findById(long id);


}
