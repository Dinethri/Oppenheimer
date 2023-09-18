package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addHeroDropDown = By.id("dropdownMenuButton2");
    private By selectUploadCSV = By.xpath("/html/body/div[2]/div[2]/div/div/div/ul/li[2]/a[contains(text(),'Upload a csv file')]");

    public void clickAddHeroDropdown() {
        driver.findElement(addHeroDropDown).click();
    }

    public void selectUploadCSV() {
        driver
                .findElement(selectUploadCSV)
                .click();
    }

}

