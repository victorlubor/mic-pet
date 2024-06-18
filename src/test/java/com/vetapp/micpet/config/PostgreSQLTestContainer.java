package com.vetapp.micpet.config;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgreSQLTestContainer extends PostgreSQLContainer<PostgreSQLTestContainer> {

  private static final String IMAGE_VERSION = "postgres:15-alpine";
  private static PostgreSQLTestContainer container;

  private PostgreSQLTestContainer() {
    super(IMAGE_VERSION);
  }

  public static PostgreSQLTestContainer getInstance() {
    if (container == null) {
      container = new PostgreSQLTestContainer();
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
  }

  @Override
  public void stop() {
  }
}
