package com.vetapp.micpet.domain.models;

import com.vetapp.micpet.domain.errors.InvalidPetNameException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Builder
@Getter
public class Pet {

  private Long id;
  private String name;
  private Long ownerId;

  private static final String VALID_NAME_REGEX = "^[A-Z][a-z]*$";
  private static final Integer VALID_NAME_MAX_LENGTH = 20;

  public Pet(Long id, String name, Long ownerId) {
    isNameValid(name);

    this.id = id;
    this.name = name;
    this.ownerId = ownerId;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    isNameValid(name);
    this.name = name;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  private void isNameValid(String name) {
    if (name.length() > VALID_NAME_MAX_LENGTH || !name.matches(VALID_NAME_REGEX)) {
      throw new InvalidPetNameException("The pet name is invalid");
    }
  }
}
