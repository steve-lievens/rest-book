package org.ibm.ce.quarkus.starting;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PublisherResourceTest {
    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/publishers")
                .then()
                .statusCode(200);
    }

}
