package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class UploadCSVPage {
    private WebDriver driver;

    public UploadCSVPage(WebDriver driver) {
        this.driver = driver;
    }

    private By uploadFile = By.id("upload-csv-file");
    private By clickCreate = By.xpath("/html/body/div[2]/div[3]/div[3]/button");
    private By getMessage = By.xpath("//*[@id=\"notification-block\"]/div/h3");

    public void selectCSV(String filePath) {

        this.driver.findElement(uploadFile).sendKeys(filePath);
    }

    public void createButtonClick() {
        this.driver.findElement(clickCreate).click();
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getResponseMessage() {
        return this.driver.findElement(getMessage).getText();
    }
}

