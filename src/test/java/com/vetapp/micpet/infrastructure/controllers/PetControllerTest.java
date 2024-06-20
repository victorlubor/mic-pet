package com.vetapp.micpet.infrastructure.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.vetapp.micpet.application.services.PetService;
import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.controllers.dtos.CreatePetDtoIn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PetControllerTest {

  @InjectMocks
  private PetController petController;
  @Mock
  private PetService petService;

  @Test
  void createPet_ok() {
    given(petService.createPet(any(CreatePetDtoIn.class))).willReturn(any(Pet.class));

    ResponseEntity<Pet> response = petController.createPet(new CreatePetDtoIn());

    verify(petService).createPet(new CreatePetDtoIn());
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
  }
}
