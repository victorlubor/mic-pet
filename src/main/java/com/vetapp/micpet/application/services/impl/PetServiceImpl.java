package com.vetapp.micpet.application.services.impl;

import com.vetapp.micpet.application.mappers.PetMapperApp;
import com.vetapp.micpet.application.services.PetService;
import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.domain.ports.output.PetRepository;
import com.vetapp.micpet.infrastructure.controllers.dtos.CreatePetDtoIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;
  private final PetMapperApp petMapperApp;

  @Override
  public Pet createPet(CreatePetDtoIn dtoIn) {

    Pet pet = petMapperApp.dtoToDomain(dtoIn);

    return petRepository.save(pet);
  }
}
