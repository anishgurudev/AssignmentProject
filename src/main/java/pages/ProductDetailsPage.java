package pages;

import dev.failsafe.internal.util.Assert;
import locators.ProductDetailsPageLocators;
import org.openqa.selenium.*;


import java.util.Map;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductDetails(Map<String, String> expected) {
        String title = driver.findElement(By.id(ProductDetailsPageLocators.TITLE)).getText();
        String price = driver.findElement(By.id(ProductDetailsPageLocators.PRICE)).getText().replaceAll("[^0-9.]", "");
        String rating = driver.findElement(By.xpath(ProductDetailsPageLocators.RATING)).getText().split(" ")[0];
        String reviews = driver.findElement(By.id(ProductDetailsPageLocators.REVIEWS)).getText().split(" ")[0];

        Assert.isTrue(title.contains(expected.get("Product Title")), "Title does not match");
        Assert.isTrue(price.contains(expected.get("Price").replace("$", "")), "Price does not match");
        Assert.isTrue(rating.startsWith(expected.get("Rating").substring(0, 1)), "Rating mismatch");
        Assert.isTrue(reviews.contains(expected.get("Number of Reviews").split(" ")[0]), "Review count mismatch");
    }
}
