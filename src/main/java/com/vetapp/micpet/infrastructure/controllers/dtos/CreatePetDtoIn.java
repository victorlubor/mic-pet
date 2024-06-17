package com.vetapp.micpet.infrastructure.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePetDtoIn {

  private String name;
  private Long ownerId;

}
