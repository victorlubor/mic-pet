package com.vetapp.micpet.domain.ports.input;

import com.vetapp.micpet.domain.models.Pet;

public interface PetService {

    Pet createPet(Pet pet);

}
