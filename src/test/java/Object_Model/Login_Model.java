package Object_Model;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Login_Model extends Base_Model{

    private static String LOGIN_URL = "login_url";
    private static String DESTINATION_URL = "destination_url";
    public Login_Model(WebDriver driver) {
        super(driver);
    }

    public void open() {

        String loginUrl = super.resource.getString(LOGIN_URL);
        driver.manage().window().maximize();
        driver.get(loginUrl);
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).isDisplayed();
    }

    public void login(String user, String password) throws InterruptedException {
        WebElement username= driver.findElement(By.id("username-in"));
        WebElement passwordElement= driver.findElement(By.id("password-in"));
        WebElement login= driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/input"));///html/body/form/div[3]/div[2]/input
        username.sendKeys(user);
        passwordElement.sendKeys(password);
        login.click();

        String actualUrl=super.resource.getString(DESTINATION_URL);
        String expectedUrl=driver.getCurrentUrl();
        System.out.println(expectedUrl);
        Assertions.assertEquals(actualUrl, expectedUrl,"comparing URL's");
    }

//    public void csv_uploadpage_Open(){
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
//        driver.get("http://localhost:9997/clerk/upload-csv"); //Testing webpage
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        JavascriptExecutor js = (JavascriptExecutor)driver; //Scrolling using JavascriptExecutor
//        js.executeScript("window.scrollBy(0,380)");
//    }

    public void csv_upload(){
        WebElement browse = driver.findElement(By.id("upload-csv-file"));
    }

    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.className("_9ay7"));
        return errorPage.getText();
    }
}
