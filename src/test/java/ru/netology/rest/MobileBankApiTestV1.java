package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import  io.restassured.http.ContentType;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
      // Given - When - Then
      // Предусловия
      given()
          .baseUri("http://localhost:9999/api/v1")
      // Выполняемые действия
      .when()
          .get("/demo/accounts")
      // Проверки
      .then()
          .statusCode(200)
          .body(matchesJsonSchemaInClasspath("accounts.schema.json"))

      ;
    }
    @Test
    void shouldReturnDemoAccountsCurrency() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .body("[0].currency", equalTo("RUR"))
        ;
}
}
