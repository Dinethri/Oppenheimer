package API_Tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class UserStory_04 {

    @Test
    private void workingClassCreation(){

        RestAssured.baseURI = "http://localhost:9997/api/v1/hero/vouchers";
        RestAssured.given().header("Content-Type","application/json").body("{\n" +
                        "    \"natid\": \"12345\",\n" +
                        "    \"name\": \"John Doe\",\n" +
                        "    \"gender\": \"Male\",\n" +
                        "    \"birthDate\": \"1990-01-01\",\n" +
                        "    \"deathDate\": \"\",\n" +
                        "    \"salary\": 50000.0,\n" +
                        "    \"taxPaid\": 7500.0,\n" +
                        "    \"browniePoints\": 100,\n" +
                        "    \"vouchers\": [\n" +
                        "        {\n" +
                        "            \"voucherName\": \"VOUCHER 1\",\n" +
                        "            \"voucherType\": \"TRAVEL\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}").post().then()
                .log().all().assertThat().statusCode(201);


    }




}
