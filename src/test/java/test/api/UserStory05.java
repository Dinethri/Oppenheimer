package test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.*;
import specs.ApiSpecifications;

import static io.restassured.RestAssured.given;

public class UserStory05
{
    private static final String OWE_MONEY_URL = "http://localhost:9997/api/v1/hero/owe-money";
    @Test
    public void getRequestAutomation(){

        RestAssured.baseURI = OWE_MONEY_URL;
        Response response = given()
                .spec(ApiSpecifications.getRequestSpecification())
                .when()
                .get("/hero/owe-money");
        response.then().statusCode(400);

    }

}
