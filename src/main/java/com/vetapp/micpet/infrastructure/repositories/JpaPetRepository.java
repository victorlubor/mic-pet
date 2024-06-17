package com.vetapp.micpet.infrastructure.repositories;

import com.vetapp.micpet.infrastructure.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPetRepository extends JpaRepository<PetEntity, Long> {

}
