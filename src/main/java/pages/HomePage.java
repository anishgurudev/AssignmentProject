package pages;

import locators.HomePageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchFor(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HomePageLocators.SEARCH_BOX)));
        searchBox.sendKeys(productName);
        driver.findElement(By.id(HomePageLocators.SEARCH_BUTTON)).click();
    }
}
