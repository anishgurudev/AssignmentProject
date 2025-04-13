package pages;

import locators.SearchResultsPageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.*;

public class SearchResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void applyFourStarFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchResultsPageLocators.FOUR_STAR_FILTER))).click();
    }

    public List<Map<String, String>> extractValidProducts(int minPrice, int maxPrice) {
        List<Map<String, String>> products = new ArrayList<>();
        List<WebElement> productBlocks = driver.findElements(By.xpath(SearchResultsPageLocators.PRODUCT_BLOCK));

        for (WebElement block : productBlocks) {
            try {
                String title = block.findElement(By.cssSelector(SearchResultsPageLocators.PRODUCT_TITLE)).getText();
                String priceText = block.findElement(By.cssSelector(SearchResultsPageLocators.PRODUCT_PRICE)).getText().replace(",", "");
                double price = Double.parseDouble(priceText);
                String ratingText = block.findElement(By.cssSelector(SearchResultsPageLocators.PRODUCT_RATING)).getAttribute("innerHTML").split(" ")[0];
                double rating = Double.parseDouble(ratingText);
                String reviews = block.findElement(By.cssSelector(SearchResultsPageLocators.PRODUCT_REVIEWS)).getText();

                if (price >= minPrice && price <= maxPrice && rating >= 4.0) {
                    Map<String, String> product = new HashMap<>();
                    product.put("Product Title", title);
                    product.put("Price", "$" + price);
                    product.put("Rating", String.valueOf(rating));
                    product.put("Number of Reviews", reviews);
                    products.add(product);
                }
            } catch (Exception e) {
                System.out.println("Skipping invalid or incomplete product entry.");
            }
        }
        return products;
    }

    public void clickFirstProduct() {
        WebElement first = driver.findElement(By.cssSelector(SearchResultsPageLocators.PRODUCT_LINK));
        first.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
