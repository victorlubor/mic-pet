package com.vetapp.micpet.infrastructure.adapters;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.domain.ports.output.PetRepository;
import com.vetapp.micpet.infrastructure.entities.PetEntity;
import com.vetapp.micpet.infrastructure.repositories.JpaPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaPetRepositoryAdapter implements PetRepository {

    private final JpaPetRepository jpaPetRepository;

    @Override
    public Pet save(Pet pet) {
        PetEntity entity = PetEntity.fromDomain(pet);
        entity = jpaPetRepository.save(entity);

        return entity.toDomainModel();
    }
}
