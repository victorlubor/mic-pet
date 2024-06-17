package com.vetapp.micpet.infrastructure.mappers;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.entities.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapperInfra {

  PetEntity domainToEntity(Pet pet);

  Pet entityToDomain(PetEntity entity);

}
