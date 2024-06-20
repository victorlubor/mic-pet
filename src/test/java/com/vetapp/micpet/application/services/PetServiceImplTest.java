package com.vetapp.micpet.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vetapp.micpet.application.mappers.PetMapperApp;
import com.vetapp.micpet.application.services.impl.PetServiceImpl;
import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.domain.ports.output.PetRepository;
import com.vetapp.micpet.infrastructure.controllers.dtos.CreatePetDtoIn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PetServiceImplTest {

  @Mock
  private PetRepository petRepository;
  @Mock
  private PetMapperApp petMapperApp;

  @InjectMocks
  private PetServiceImpl petServiceImpl;

  @Test
  void createPet_whenCalled_doesMappingsCorrectly() {
    CreatePetDtoIn createPetDtoIn = new CreatePetDtoIn();
    Pet pet = new Pet();

    when(petMapperApp.dtoToDomain(any(CreatePetDtoIn.class))).thenReturn(pet);
    when(petRepository.save(any(Pet.class))).thenReturn(pet);

    Pet result = petServiceImpl.createPet(createPetDtoIn);

    verify(petMapperApp).dtoToDomain(createPetDtoIn);
    verify(petRepository).save(pet);
    assertEquals(pet, result);
  }
}
