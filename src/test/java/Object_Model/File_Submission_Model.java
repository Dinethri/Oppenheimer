package Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class File_Submission_Model extends Base_Model{

    private static final String UPLOAD_URL = "upload_url";
    public File_Submission_Model(WebDriver driver) {
        super(driver);
    }

    public void csv_uploadpage_open() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
        driver.get(super.resource.getString(UPLOAD_URL)); //Testing webpage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor)driver; //Scrolling using JavascriptExecutor
        js.executeScript("window.scrollBy(0,380)");

    }

    public String csv_uploadpage_run() {
        WebElement browse = driver.findElement(By.id("upload-csv-file"));
        browse.sendKeys("C:/Users/Sasitha/Desktop/NY.csv"); //Uploading the file using sendKeys
        WebElement createbutton= driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/button"));
        createbutton.click();
//            success message validation
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"notification-block\"]/div/h3"));
        String messageText = successMessage.getText();

        return messageText;
    }
}
