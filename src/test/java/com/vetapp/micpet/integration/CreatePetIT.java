package com.vetapp.micpet.integration;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.repositories.JpaPetRepository;
import com.vetapp.micpet.integration.base.BaseIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

class CreatePetIT extends BaseIntegrationTest {

  private static final String CREATE_PET_ENDPOINT = "/api/v1/pets";
  @Autowired
  private JpaPetRepository petRepository;

  @AfterEach
  void afterEach() {
    petRepository.deleteAll();
  }

  @Test
  void createPet_whenAllParamsOk_ok() {

    // language=json
    String jsonBody = """
        {
          "name": "Prueba",
          "ownerId": 1
        }
        """;

    Pet pet = given()
        .contentType("application/json")
        .body(jsonBody)
        .when()
        .post(CREATE_PET_ENDPOINT)
        .then()
        .statusCode(HttpStatus.CREATED.value())
        .extract()
        .as(Pet.class);

    assertNotNull(pet);
    assertEquals("Prueba", pet.getName());
  }
}
