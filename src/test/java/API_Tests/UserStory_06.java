package API_Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserStory_06 {

    private static final String API_BASE_URL = "http://localhost:9997"; // Replace with your API base URL
    private WebDriver driver;

    @Test
    public void testVoucherInsights() {
        RestAssured.baseURI = "http://localhost:9997/api/v1/voucher/by-person-and-type";

        Response response = RestAssured.given().param("voucher_type", "default").header("Content-Type", "application/json").when().get();
        System.out.println(response.getBody().asString());
        System.out.println("get status code :" + response.statusCode());
        System.out.println("content type :" + response.contentType());
        System.out.println("time :" + response.getTime());
        System.out.println("cookies :" + response.getCookies());
        System.out.println("response :" + response.prettyPrint());
    }
}
