package com.vetapp.micpet.application.services;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.domain.ports.input.PetService;
import com.vetapp.micpet.domain.ports.output.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;

  @Override
  public Pet createPet(Pet pet) {
    return petRepository.save(pet);
  }
}
