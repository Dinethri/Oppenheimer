package test.api;
import com.google.gson.Gson;
import dataaccess.Repository;
import io.restassured.response.Response;
import model.Hero;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import specs.ApiSpecifications;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class UserStory01 {
    private static final String HEROES_DATA = "src/test/resources/heroData.json";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private Hero hero;
    private Response response;
    @BeforeClass
    public void setUp() throws FileNotFoundException {

        Gson gson = new Gson();
        this.hero = gson.fromJson(new FileReader(HEROES_DATA), Hero.class);
    }

    @Test(priority = 1)
    public void validatePayload() {

        Assert.assertTrue(this.hero.getNatid().matches("natid-\\d{1,7}"), "Invalid natid format");// need to have 2 assertions
        Assert.assertTrue(this.hero.getName().matches("[A-Za-z\\s]{1,100}"), "Invalid name format");
        Assert.assertTrue(this.hero.getGender().equals("MALE") || this.hero.getGender().equals("FEMALE"), "Invalid gender");
        Assert.assertTrue(isValidBirthDateFormat(this.hero.getBirthDate()), "Invalid birthDate format or future date");
        Assert.assertTrue(this.hero.getDeathDate() == null || isValidDeathDateFormat(this.hero.getDeathDate()), "Invalid deathDate format");
        Assert.assertTrue(this.hero.getSalary() >= 0, "Salary cannot be negative");
        Assert.assertTrue(this.hero.getTaxPaid() >= 0, "TaxPaid cannot be negative");
        Assert.assertTrue(this.hero.getBrowniePoints() == 0 || this.hero.getBrowniePoints() >= 0, "Invalid browniePoints");
    }
    @Test(priority = 2)
    public void testHeroCreation () {

        JSONObject heroJSON = new JSONObject(hero);
        this.response = given()
            .spec(ApiSpecifications.getRequestSpecification())
            .body(heroJSON.toString())
            .when()
            .post("/hero");
        this.response.then().log().all().assertThat().statusCode(200);

    }

    @Test(priority = 3)
    public void fetchHeroFromDB (){

        Repository hero = new Repository();
        Hero dbHero = hero.getUserById(this.hero.getNatid());
        Assert.assertNotNull(dbHero.getNatid(), "Value not inserted");
    }

    private boolean isValidBirthDateFormat(String birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(birthDate);
            Date currentDate = new Date();
            if (parsedDate.after(currentDate)) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidDeathDateFormat(String deathDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(deathDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
