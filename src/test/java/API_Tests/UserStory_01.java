package API_Tests;
import DB_methods.WorkingClassHeroesImpl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class UserStory_01 {
        private static final String API_BASE_URL = "http://localhost:9997/"; // Replace with your API base URL
        private WebDriver driver;

        @Test
        public void testHeroCreation () {

                RestAssured.baseURI = "http://localhost:9997/api/v1/hero";
                RestAssured.given().header("Content-Type","application/json").body("{\n" +
                    "\"natid\": \"natid-12\",\n" +
                    "\"name\": \"hello\",\n" +
                    "\"gender\": \"MALE\",\n" +
                    "\"birthDate\": \"2020-01-01T23:59:59\",\n" +
                    "\"deathDate\": null,\n" +
                    "\"salary\": 10.00,\n" +
                    "\"taxPaid\": 1,\n" +
                    "\"browniePoints\": 9\n" +
                    "}").post().then()
                        .log().all().assertThat().statusCode(200);


        }

}
