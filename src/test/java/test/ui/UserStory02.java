package test.ui;

import config.ConnectionObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UploadCSVPage;

import java.util.ResourceBundle;

public class UserStory02 {

    private WebDriver driver;

    private ResourceBundle resource;

    @BeforeClass
    public void setUp() {
        ConnectionObject connection = new ConnectionObject();
        this.driver = connection.getDriver();
        this.resource = ResourceBundle.getBundle("config");
        String loginUrl = resource.getString("base_url") + "login";
        this.driver.manage().window().maximize();
        this.driver.get(loginUrl);
    }

    @Test(priority = 1)
    public void testLogin() {
        LoginPage loginPage = new LoginPage(this.driver);

        loginPage.enterUsername("clerk");
        loginPage.enterPassword("clerk");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void testDashboard() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.clickAddHeroDropdown();
        dashboardPage.selectUploadCSV();
    }

    @Test(priority = 3)
    public void testUploadCSV() {

        UploadCSVPage uploadCSVPage = new UploadCSVPage(this.driver);
        uploadCSVPage.selectCSV(resource.getString("file_path"));
        uploadCSVPage.createButtonClick();
        uploadCSVPage.implicitlyWait();
        String response = uploadCSVPage.getResponseMessage();

        Assert.assertEquals(response, "Unable to create hero!" , "Upload fail scenario");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
