package com.vetapp.micpet.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.vetapp.micpet.domain.errors.InvalidPetNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PetTest {

  @Test
  void constructor_whenCalledWithValidParams_ok() {
    Long id = 1L;
    String name = "Buddy";
    Long ownerId = 1L;

    Pet pet = new Pet(id, name, ownerId);

    assertEquals(id, pet.getId());
    assertEquals(name, pet.getName());
    assertEquals(ownerId, pet.getOwnerId());
  }

  @ParameterizedTest
  @ValueSource(strings = {"NaMe, name, nameeeeeeeeeeeeeeeeeeeeeeeeeee, Name1"})
  void constructor_whenCalledWithInvalidName_throwsInvalidPetNameException(String name) {

    Long id = 1L;
    Long ownerId = 1L;

    Executable execution = () -> new Pet(id, name, ownerId);
    assertThrows(InvalidPetNameException.class, execution);
  }

  @Test
  void setName_whenValidName_ok() {
    Pet pet = new Pet();
    String validName = "Name";

    pet.setName(validName);

    assertEquals(validName, pet.getName());
  }

  @Test
  void setName_whenInvalidName_throwsInvalidPetNameException() {
    Pet pet = new Pet();
    String invalidName = "name";

    // Act & Assert
    Executable execution = () -> pet.setName(invalidName);
    assertThrows(InvalidPetNameException.class, execution);
  }
}
