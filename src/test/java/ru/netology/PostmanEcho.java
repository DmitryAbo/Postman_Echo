package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PostmanEcho {

    @Test
    public void shouldSendTextData() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Abornev_ECHO") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .contentType("text/plain; charset=UTF-8")
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Abornev_ECHO"))
                .body("json.data", equalTo(null))
        ;
    }

    @Test
    public void shouldSendJsonData() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("{\n" +
                        "    \"data\": \"Abornev_ECHO\"\n" +
                        "}") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .contentType("application/json")
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data.data", equalTo("Abornev_ECHO"))
                .body("json.data", equalTo("Abornev_ECHO"))
        ;
    }
}
