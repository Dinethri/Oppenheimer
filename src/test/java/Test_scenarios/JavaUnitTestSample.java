package Test_scenarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import example.util.Calculator;

import Config.Connection_Object;
import Object_Model.Login_Model;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaUnitTestSample {

    private WebDriver driver;
    private Login_Model loginPage;
    @BeforeTest
    public void setup() {
        System.out.println("===================12");
        Connection_Object connection = new Connection_Object();
        this.driver = connection.getDriver();
        this.loginPage = new Login_Model(this.driver);
    }

    @Test(priority = 1)
    public void login_to_System() throws InterruptedException {

        System.out.println("=====================1");
        loginPage.open();
        try {
            loginPage.login("clerk", "clerk");
            Thread.sleep(5000);
            System.out.println("=====================2");
        }catch(Exception e){
                System.out.println(e);
            }
//        assertTrue(loginPage.isLoaded());
    }



    @AfterTest
    public void closePro() {
        this.driver.quit();
    }
}
