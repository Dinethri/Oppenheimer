package TestObjects;

//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTest {

//    @BeforeClass
//    public void beforeClass() throws Exception {
//        try {
//            System.out.println("sample test");
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    @Test
    public void verifyProductCreationAndAttachingToDeal() throws Exception {
        try {
//            System.out.println("sssss");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sasitha\\Desktop\\webDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
            driver.get("http://localhost:9997/login");
            WebElement username= driver.findElement(By.id("username-in"));
            WebElement password= driver.findElement(By.id("password-in"));
            WebElement login= driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/input"));///html/body/form/div[3]/div[2]/input
            username.sendKeys("clerk");
            password.sendKeys("clerk");
            login.click();

            String actualUrl="http://localhost:9997/clerk/dashboard";
            String expectedUrl=driver.getCurrentUrl();
            System.out.println(expectedUrl);
            Assertions.assertEquals(actualUrl, expectedUrl,"comparing URL's");




//            WebDriver d = new FirefoxDriver();
//            driver.manage().window().maximize(); //always write wait code after this
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
            driver.get("http://localhost:9997/clerk/upload-csv"); //Testing webpage
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //for Implicit wait

            JavascriptExecutor js = (JavascriptExecutor)driver; //Scrolling using JavascriptExecutor
            js.executeScript("window.scrollBy(0,380)");//Scroll Down to file upload button (+ve)
            Thread.sleep(3000);

            // FILE UPLOADING USING SENDKEYS ....

            WebElement browse = driver.findElement(By.id("upload-csv-file"));
            //click on ‘Choose file’ to upload the desired file
            browse.sendKeys("C:\\Users\\Sasitha\\Desktop\\NY.csv"); //Uploading the file using sendKeys
            System.out.println("File is Uploaded Successfully");

        } catch (Exception e) {
            throw e;
        }
    }
}
