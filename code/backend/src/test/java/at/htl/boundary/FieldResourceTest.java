package at.htl.boundary;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class FieldResourceTest {
    @Test
    public void testThatGetAllFieldsWorks(){
        RestAssured.given()
                .when().get("/api/field")
                .then()
                .statusCode(200);
    }
}