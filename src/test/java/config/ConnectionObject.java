package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConnectionObject {

    public WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        return chromeDriver;
    }
}
