package com.spacehotel.app.application.domain.repositories;

import com.spacehotel.app.application.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findById(long id);
    ClientEntity findByEmail(String email);

}

