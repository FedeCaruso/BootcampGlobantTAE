import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Example_1_DemoApiTesting {

    @Test
    public void testGetUsers(){
        //Base URL for the API
        RestAssured.baseURI = "https://reqres.in/api";

        //GET Request and print the response in the console
        String responseBody = RestAssured
                                    .given()
                                    .when()
                                        .get("/users")
                                    .then()
                                        .statusCode(200)
                                        .extract().body().asString();

        System.out.println(responseBody);
    }

    @Test
    public void testGetUsersAndVerifyAName(){
        //Base URL for the API
        RestAssured.baseURI = "https://reqres.in/api";

        //GET request using hamcrest assertions
        RestAssured
                .given()
                .when()
                    .get("/users")
                .then()
                    .statusCode(200)
                    .body("data[1].first_name", equalTo("Janet"));
    }

    @Test
    public void testPostUser(){
        //Base URL for the API
        RestAssured.baseURI = "https://reqres.in/api";

        //Create JSON to send it in the body of the request
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        bodyMap.put("name", "Alejandra");
        bodyMap.put("job", "TAE");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(bodyMap);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //POST Request
        RestAssured
                .given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    //.body("{\n" +
                    //    "\"name\": \"morpheus\"," +
                    //    "\"job\": \"leader\"\n" +
                    //  '}')
                    .body(json)
                .when()
                    .post("/users")
                .then()
                    .log().all()
                    .statusCode(201);
    }

    @Test
    public void testPostLogin(){
        //Base URL for the API
        RestAssured.baseURI = "https://reqres.in/api";

        //Create JSON to send it in the body of the request
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        bodyMap.put("email", "eve.holt@reqres.in");
        bodyMap.put("password", "cityslicka");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(bodyMap);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //POST Request
        RestAssured
                .given()
                    .log().all()
                .contentType(ContentType.JSON)
                //.body("{\n" +
                //    "\"email\": \"eve.holt@reqres.in\"," +
                //    "\"password\": \"cityslicka\"\n" +
                //   '}')
                    .body(json)
                .when()
                    .post("login")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("token", notNullValue());
    }
}
