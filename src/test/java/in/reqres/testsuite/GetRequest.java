package in.reqres.testsuite;

import in.reqres.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequest extends TestBase {

    @Test
    public void getListUsers() {
        given()
                .log()
                .parameters()
                .param("page","2")
                .when()
                .log()
                .uri()
                .get("/users")
                .then().body("ad.company",equalTo("StatusCode Weekly"))
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void getSingleUser() {
        given()
                .log()
                .headers()
                .when()
                .log()
                .uri()
                .get("/users/2")
                .then().body("data.first_name", equalTo("Janet"))
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void getSingleUserNotFound() {
        given()
                .log()
                .headers()
                .when()
                .log()
                .uri()
                .get("/users/23")
                .then().body(equalTo("{}"))
                .log()
                .body()
                .statusCode(404);

    }


}
