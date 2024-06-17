package com.vetapp.micpet.domain.ports.output;

import com.vetapp.micpet.domain.models.Pet;

public interface PetRepository {

  Pet save(Pet pet);

}
