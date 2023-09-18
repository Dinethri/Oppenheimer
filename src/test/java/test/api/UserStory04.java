package test.api;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import model.Hero;
import model.Vouchers;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.*;
import specs.ApiSpecifications;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

@Listeners(config.ListenerTest.class)
public class UserStory04 {

    private static final Logger logger = LogManager.getLogger(UserStory04.class);
    private static final String VOUCHER_URL = "http://localhost:9997/api/v1/hero/vouchers";
    private static final String VOUCHER_DATA = "src/test/resources/voucherData.json";

    @BeforeClass
    public void setUp() {
        BasicConfigurator.configure();
    }

    @Test(priority = 1)
    public void validatePayloadforVoucher() {
        //implementation
    }

    //User Story 04/AC1
    @Test(priority = 2)
    public void workingClassCreation() throws FileNotFoundException {
        logger.info("invoked workingClassCreation test");
        RestAssured.baseURI = VOUCHER_URL;
        Gson gson = new Gson();
        Vouchers vouchers = gson.fromJson(new FileReader(VOUCHER_DATA), Vouchers.class);

        System.out.println(vouchers);
        JSONObject voucherJSON = new JSONObject(vouchers);
        given()
                .spec(ApiSpecifications.getRequestSpecification())
                .body(voucherJSON.toString())
                .when()
                .post("/hero/vouchers")
                .then()
                .statusCode(200);
    }

}
