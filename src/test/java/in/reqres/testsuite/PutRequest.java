package in.reqres.testsuite;

import in.reqres.pojo.Pojo;
import in.reqres.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutRequest extends TestBase {

    @Test
    public void updateUserPut() {
        Pojo pojo = new Pojo();

        pojo.setName("morpheus");
        pojo.setJob("zion resident");

        given()
                .log()
                .body()
                .when()
                .body(pojo)
                .put("/users/2")
                .then()
                .log()
                .body()
                .log()
                .status()
                .statusCode(200);
    }

}
