package com.vetapp.micpet.integration.base;

import com.vetapp.micpet.MicPetApplication;
import com.vetapp.micpet.config.PostgreSQLTestContainer;
import io.restassured.RestAssured;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(classes = MicPetApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"tc", "tc-auto"})
@RunWith(SpringRunner.class)
public class BaseIntegrationTest {

  @ClassRule
  public static PostgreSQLContainer<PostgreSQLTestContainer> postgreSQLContainer = PostgreSQLTestContainer.getInstance();

  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
  }

}
