package test.ui;

import config.ConnectionObject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BookKeeperDashboardPage;
import pages.LoginPage;

import java.util.ResourceBundle;

@Listeners(config.ListenerTest.class)
public class UserStory03 {

    private WebDriver driver;

    private ResourceBundle resource;

    private static final Logger logger = LogManager.getLogger(UserStory03.class);

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
        loginPage.enterUsername("bk");
        loginPage.enterPassword("bk");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void testBookDashboard() throws InterruptedException {
        logger.info("invoked testBookDashboard test");
        BookKeeperDashboardPage bookDashboardPage = new BookKeeperDashboardPage(this.driver);
        String initialText = bookDashboardPage.responseGenarateTax();
        if (initialText.equals("Nothing running at the moment")) {
            bookDashboardPage.clickGenarateTax();
            bookDashboardPage.implicitlyWait();
        }

        Thread.sleep(2000);
        String response = bookDashboardPage.responseGenarateTax();
        Assert.assertEquals(response, "Egress Tax Relief file process in progress", "Generating tax file");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
