package test.ui;

import config.ConnectionObject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UploadCSVPage;

import java.util.ResourceBundle;

@Listeners(config.ListenerTest.class)
public class UserStory02 {


    private WebDriver driver;

    private ResourceBundle resource;

    private static final Logger logger = LogManager.getLogger(UserStory02.class);

    @BeforeClass
    public void setUp() {

        ConnectionObject connection = new ConnectionObject();
        this.driver = connection.getDriver();
        this.resource = ResourceBundle.getBundle("config");
        String loginUrl = resource.getString("base_url") + "login";
        this.driver.manage().window().maximize();
        this.driver.get(loginUrl);
        BasicConfigurator.configure();
    }

    @Test(priority = 1)
    public void testLogin() {
        logger.info("invoked testLogin test");
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.enterUsername("clerk");
        loginPage.enterPassword("clerk");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void testDashboard() {
        logger.info("invoked testDashboard test");
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.clickAddHeroDropdown();
        dashboardPage.selectUploadCSV();
    }

    @Test(priority = 3)
    public void testUploadCSV() {
        logger.info("invoked testUploadCSV test");
        UploadCSVPage uploadCSVPage = new UploadCSVPage(this.driver);
        uploadCSVPage.selectCSV(resource.getString("file_path"));
        uploadCSVPage.createButtonClick();
        uploadCSVPage.implicitlyWait();
        String response = uploadCSVPage.getResponseMessage();

        Assert.assertEquals(response, "Unable to create hero!", "Upload fail scenario");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
