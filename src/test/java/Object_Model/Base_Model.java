package Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ResourceBundle;

public class Base_Model {

    private static String CONFIG = "config";
    public final WebDriverWait wait;
    protected WebDriver driver;
    public final ResourceBundle resource;
    public Base_Model(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.resource = ResourceBundle.getBundle(CONFIG);
    }
}
