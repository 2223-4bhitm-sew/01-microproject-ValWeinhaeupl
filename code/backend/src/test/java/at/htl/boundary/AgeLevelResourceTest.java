package at.htl.boundary;

import at.htl.entity.AgeLevel;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class AgeLevelResourceTest {
    @Test
    public void testThatThereAreAllAgeLevels() {
        RestAssured.given()
                .when().get("/api/agelevel")
                .then()
                .statusCode(200);
    }

    @Test
    public void testThatGetByNameWorks(){
        RestAssured.given()
                .when().get("/api/agelevel?agelevelname=Senior")
                .then()
                .statusCode(200);
    }
}