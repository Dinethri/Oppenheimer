package TestObjects;

import org.openqa.selenium.WebDriver;
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
import org.testng.Assert;
public class User_Story_02 {

    WebDriver driver;

    public User_Story_02(WebDriver driver){
        this.driver = driver;

    }

    By U_name = By.id("username-in");

    public void entercre (String Inputs){
        this.driver.findElement(U_name).sendKeys(Inputs);
    }

}
