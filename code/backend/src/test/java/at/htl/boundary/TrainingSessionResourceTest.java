package at.htl.boundary;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TrainingSessionResourceTest {
    @Test
    public void testThatGetAllTrainingSessionsWorks(){
        RestAssured.given()
                .when().get("/api/trainingsession")
                .then()
                .statusCode(200);
    }
}