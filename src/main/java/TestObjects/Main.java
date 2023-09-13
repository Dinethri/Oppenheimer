package TestObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;

public class Main {

    public static void main(String args[]) {
        // TODO Auto-generated constructor stub
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sasitha\\Desktop\\webDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
        driver.get("http://localhost:9997/login");

    }
}