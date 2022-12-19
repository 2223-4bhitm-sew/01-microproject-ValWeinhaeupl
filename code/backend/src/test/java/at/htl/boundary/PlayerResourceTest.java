package at.htl.boundary;

import at.htl.entity.Player;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PlayerResourceTest {
    @Test
    public void testThatGetAllPlayersWorks(){
        RestAssured.given()
                .when().get("/api/player")
                .then()
                .statusCode(200);
    }

    @Test
    public void testThatPostWorks(){
        Player player = new Player("Max", "Mustermann", "Stuermer", 1);
        with().body(player)
                .when()
                .request("POST", "/api/player")
                .then()
                .statusCode(201);
    }

}