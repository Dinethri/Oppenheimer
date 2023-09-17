package test.api;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import model.Vouchers;
import org.json.JSONObject;
import org.testng.annotations.*;
import specs.ApiSpecifications;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class UserStory04 {

    private static final String VOUCHER_URL = "http://localhost:9997/api/v1/hero/vouchers";
    private static final String VOUCHER_DATA = "src/test/resources/voucherData.json";
    @Test
    public void workingClassCreation() throws FileNotFoundException {

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
