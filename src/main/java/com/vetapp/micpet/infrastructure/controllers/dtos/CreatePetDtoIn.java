package com.vetapp.micpet.infrastructure.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePetDtoIn {

  @NotBlank
  private String name;
  @NotNull
  private Long ownerId;

}
