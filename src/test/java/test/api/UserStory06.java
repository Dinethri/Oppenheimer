package test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import specs.ApiSpecifications;

import static io.restassured.RestAssured.*;

public class UserStory06 {

    private Response response;
    @Test
    public void testVoucherInsights() {
        this.response = given()
            .spec(ApiSpecifications.getRequestSpecification())
            .when()
            .get("/voucher/by-person-and-type");

        response.then().statusCode(200);
    }
}
