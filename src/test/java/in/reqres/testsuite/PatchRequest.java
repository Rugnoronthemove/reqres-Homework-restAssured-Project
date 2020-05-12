package in.reqres.testsuite;

import in.reqres.pojo.Pojo;
import in.reqres.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchRequest extends TestBase {

    @Test
    public void updateUserPatch() {
        Pojo pojo = new Pojo();

        pojo.setName("neo");
        pojo.setJob("The chosen One");

        given()
                .log()
                .body()
                .when()
                .body(pojo)
                .patch("/users/7")
                .then()
                .log()
                .status()
                .log()
                .body()
                .statusCode(200);
    }
}
