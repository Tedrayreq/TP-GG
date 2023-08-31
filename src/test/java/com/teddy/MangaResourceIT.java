package com.teddy;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class MangaResourceIT {
    @Inject
    MangaRepository mangaRepository;

    @Test
    public void shouldReturnMangas() {
        mangaRepository.persist(new MangaEntity("Berserk", "Kentaro", "seinen"));
        given()
                .when().get("/mangas")
                .then()
                    .statusCode(200)
                    .body("[0].title", equalTo("Berserk"))
                    .body("[0].author", equalTo("Kentaro"))
                    .body("[0].genre", equalTo("seinen"));
    }

    @Test
    public void shouldReturn201AndPersistManga() {
        given()
                .header("Content-Type", "application/json")
                .and()
                .body("{\"title\": \"Berserk\", \"author\": \"Kentaro\", \"genre\": \"seinen\"}")
                .when().post("/mangas")
                .then()
                    .statusCode(201);
        assert mangaRepository.find("title", "Berserk").firstResult().equals(new MangaEntity("Berserk", "Kentaro", "seinen"));
    }
}
