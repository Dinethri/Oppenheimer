package API_Tests;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class UserStory_05
{
    @Test
    private void getRequestAutomation(){

        RestAssured.baseURI="http://localhost:9997/api/v1/hero/owe-money";

        Response response = RestAssured.given().header("Content-Type","application/json").when().get();
//        request.header("Content-Type", "application/json");
        System.out.println(response.getBody().asString());
        System.out.println("get status code :"+response.statusCode());
        System.out.println("content type :"+ response.contentType());
        System.out.println("time :"+ response.getTime());
        System.out.println("cookies :"+ response.getCookies());
        System.out.println("response :"+response.prettyPrint());

    }


}
