package in.reqres.testsuite;

import in.reqres.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest extends TestBase {

    @Test
    public void deleteUser() {

        given()
                .log()
                .headers()
                .when()
                .delete("/users/2")
                .then()
                .log()
                .status()
                .statusCode(204);

    }
}
