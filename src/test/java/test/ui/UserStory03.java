package test.ui;

import config.ConnectionObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookKeeperDashboardPage;
import pages.LoginPage;

import java.util.ResourceBundle;

public class UserStory03 {

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
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(this.driver);

        loginPage.enterUsername("bk");
        loginPage.enterPassword("bk");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void testBookDashboard() throws InterruptedException {

        BookKeeperDashboardPage bookDashboardPage = new BookKeeperDashboardPage(this.driver);
        String initialText = bookDashboardPage.responseGenarateTax();
        if(initialText.equals("Nothing running at the moment")) {
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
