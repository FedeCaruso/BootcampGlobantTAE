import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import models.response.ListUser;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Example_3_DemoApiResponseHandling {
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
    public void getAllUsersResponse(){

        //POST Request
        Response response = given()
                .get("users?page=2");

        Headers headers = response.getHeaders();
        int statusCode = response.statusCode();
        String body = response.getBody().asString();
        String contentType = response.getContentType();

        assertThat(statusCode, equalTo(HttpStatus.SC_OK));

        System.out.println("body: " + body);
        System.out.println("content type: " + contentType);
        System.out.println("*****************************");
        System.out.println("*****************************");
        System.out.println(headers.get("Content-Type"));
        System.out.println(headers.get("Transfer-Encoding"));
    }

    @Test
    public void getAllUsersResponseAsJson(){

        //POST Request
        String response = given().when()
                .get("users?page=2").then().extract().asString();

        int page = from(response).get("page");
        int totalPages = from(response).get("total_pages");
        int idFirstUser = from(response).get("data[0].id");

        System.out.println("page: " + page);
        System.out.println("total pages: " + totalPages);
        System.out.println("id first user: " + idFirstUser);

        List<Map> usersWithIdGraterThan10 = from(response).get("data.findAll { user -> user.id > 10}");
        String email = usersWithIdGraterThan10.get(0).get("email").toString();

        List<Map> users = from(response).get("data.findAll { user -> user.id > 10 && user.last_name == 'Howell'}");
        int id = Integer.valueOf(users.get(0).get("id").toString());

    }

    @Test
    public void getAllUsersResponseAsJsonModel(){
        //GET Request
        ListUser listUser = given().when()
                .get("users?page=2").then().extract().as(ListUser.class);

        System.out.println("page: " + listUser.getPage());
        System.out.println("total pages: " + listUser.getTotalPages());
        System.out.println("id first user: " + listUser.getData().get(0).getId());

        Assert.assertEquals(listUser.getData().get(0).getId(), 7);

    }
}
