package com.vetapp.micpet.domain.errors;

public class InvalidPetNameException extends RuntimeException {

  public InvalidPetNameException(String errorMessage) {
    super(errorMessage);
  }
}
