package com.vetapp.micpet.infrastructure.controllers;

import com.vetapp.micpet.application.services.PetService;
import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.controllers.dtos.CreatePetDtoIn;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

  private final PetService petService;

  @PostMapping
  public ResponseEntity<Pet> createPet(@RequestBody @Valid CreatePetDtoIn dtoIn) {
    return new ResponseEntity<>(petService.createPet(dtoIn), HttpStatus.CREATED);
  }
}
