package at.htl.boundary;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TrainerResourceTest {
    @Test
    public void testThatGetAllTrainersWorks(){
        RestAssured.given()
                .when().get("/api/trainer")
                .then()
                .statusCode(200);
    }
}