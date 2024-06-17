package com.vetapp.micpet.application.services;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.controllers.dtos.CreatePetDtoIn;

public interface PetService {

  Pet createPet(CreatePetDtoIn dtoIn);

}
