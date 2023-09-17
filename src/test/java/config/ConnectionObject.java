package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConnectionObject {

    public WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();

//        WebDriver driver = new ChromeDriver();

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sasitha\\Desktop\\webDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }
}
