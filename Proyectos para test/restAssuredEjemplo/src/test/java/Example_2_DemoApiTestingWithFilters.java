import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Example_2_DemoApiTestingWithFilters {
    @BeforeTest
    public void setup(){
        baseURI = "https://reqres.in";
        basePath = "api";
        //LoggingFilter for logging all and replacing log().all() statements
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void testPostLogin(){
        //Create JSON to send it in the body of the request
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        bodyMap.put("email", "eve.holt@reqres.in");
        bodyMap.put("password", "cityslicka");

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonBody = null;
        try {
            jsonBody = objectMapper.writeValueAsString(bodyMap);
            System.out.println(jsonBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //POST Request
        given()
            .body(jsonBody)
        .when()
            .post("login")
        .then()
            .statusCode(200)
            //.statusCode(HttpStatus.SC_OK);
            .body("token", notNullValue());
    }

    @Test
    public void testDeleteUser(){
        //POST Request
        given()
                .when()
                .delete("user/2")
                .then()
                .statusCode(204);
                //.statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void testUpdateWithPatchUser(){
        //Create JSON to send it in the body of the request
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        bodyMap.put("name", "pepe");
        bodyMap.put("job", "QA");

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonBody = null;
        try {
            jsonBody = objectMapper.writeValueAsString(bodyMap);
            System.out.println(jsonBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //POST Request
        String nameUpdated = given()
                .body(jsonBody)
                .when()
                    .patch("user/2")
                .then()
                    .statusCode(200)
                    //.statusCode(HttpStatus.SC_OK);
                .extract()
                .jsonPath().get("name");

        assertThat(nameUpdated, equalTo("pepe"));
    }

    @Test
    public void testUpdateWithPutUser(){
        //Create JSON to send it in the body of the request
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        bodyMap.put("name", "pepe");
        bodyMap.put("job", "QA");

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonBody = null;
        try {
            jsonBody = objectMapper.writeValueAsString(bodyMap);
            System.out.println(jsonBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //POST Request
        String jobUpdated = given()
                .body(jsonBody)
                .when()
                .put("user/2")
                .then()
                .statusCode(200)
                //.statusCode(HttpStatus.SC_OK);
                .extract()
                .jsonPath().get("job");

        assertThat(jobUpdated, equalTo("QA"));
    }
}
