package in.reqres.testsuite;

import in.reqres.pojo.Pojo;
import in.reqres.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest extends TestBase {

    @Test
    public void createUser() {

        Pojo pojo = new Pojo();

        pojo.setName("morpheus");
        pojo.setJob("leader");

        given()
                .log()
                .body()
                .when()
                .body(pojo)
                .post("/users")
                .then()
                .log()
                .body()
                .statusCode(201);
    }

    @Test
    public void registerSuccessful() {

        Pojo pojo = new Pojo();

        pojo.setEmail("evelyn.holt@reqres.in");
        pojo.setPassword("pistol");

        given()
                .log()
                .body()
                .when()
                .body(pojo)

                // when execute the test with below endpoint response body --
                // { "error": "Missing email or username" }
                // status code -- 400

//                .post("/register")

                //when execute the test with the below endpoint response body --
                // {"id":"xxx", "createdAt": "xxxx-xx-xxxxx:xx:xx.xxxx"}
                // status code -- 201

                 .post("/api/register")

                .then()
                .log()
                .status()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void registerUnsuccessful() {

        Pojo pojo = new Pojo();
        pojo.setEmail("sydney@fife");


        given()
                .log()
                .body()
                .when()
                .body(pojo)
                // when execute the test with below endpoint
                // response body -- { "error": "Missing email or username" }
                // status code -- 400

                .post("/register")

                //when execute the test with the below endpoint
                // response body -- {"id":"xxx", "createdAt": "xxxx-xx-xxxxx:xx:xx.xxxx"}
                // status code -- 201

//                .post("/api/register")

                .then()
                .log()
                .status()
                .log()
                .body()
                .statusCode(400);
    }

    @Test
    public void loginSuccessful() {

        Pojo pojo = new Pojo();
        pojo.setEmail("eve.holt@reqres.in");
        pojo.setPassword("cityslicka");

        given()
                .when()
                .body(pojo)
                // when execute the test with below endpoint
                // response body -- { "error": "Missing email or username" }
                // status code -- 400

                .post("/login")

                //when execute the test with the below endpoint
                // response body -- {"id":"xxx", "createdAt": "xxxx-xx-xxxxx:xx:xx.xxxx"}
                // status code -- 201

//                .post("/api/login")

                .then()
                .log()
                .status()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void loginUnsuccessful() {

        Pojo pojo = new Pojo();
        pojo.setEmail("peter@klaven");

        given()
                .when()
                .body(pojo)
                // when execute the test with below endpoint
                // response body -- { "error": "Missing email or username" }
                // status code -- 400

                .post("/login")

                //when execute the test with the below endpoint
                // response body -- {"id":"xxx", "createdAt": "xxxx-xx-xxxxx:xx:xx.xxxx"}
                // status code -- 201

//                .post("/api/login")


                .then()
                .log()
                .status()
                .log()
                .body()
                .statusCode(400);

    }

}

