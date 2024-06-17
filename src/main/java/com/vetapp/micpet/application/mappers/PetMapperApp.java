package com.vetapp.micpet.application.mappers;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.controllers.dtos.CreatePetDtoIn;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapperApp {

  Pet dtoToDomain(CreatePetDtoIn dtoIn);

}
