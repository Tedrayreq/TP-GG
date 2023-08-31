package com.teddy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class MangaResourceIT {

    @Test
    public void shouldReturnMangas() {
        given()
                .when().get("/mangas")
                .then()
                    .statusCode(200)
                    .body(is("Berserk"));
    }
}
