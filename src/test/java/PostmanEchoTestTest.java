import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostmanEchoTestTest {
    @Test
    void shouldTakeRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void shouldTakeRequest1() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Привет Мир")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Привет Мир"))
        ;
    }
}