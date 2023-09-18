package test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import specs.ApiSpecifications;

import static io.restassured.RestAssured.given;

@Listeners(config.ListenerTest.class)
public class UserStory05 {

    private static final Logger logger = LogManager.getLogger(UserStory05.class);
    private static final String OWE_MONEY_URL = "http://localhost:9997/api/v1/hero/owe-money";

    @BeforeClass
    public void setUp() {
        BasicConfigurator.configure();
    }

    @Test
    public void getRequestAutomation() {
        logger.info("invoked getRequestAutomation test");
        RestAssured.baseURI = OWE_MONEY_URL;
        Response response = given()
                .spec(ApiSpecifications.getRequestSpecification())
                .when()
                .get("/hero/owe-money");
        response.then().statusCode(400);

    }

}
