package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import utils.CSVUtils;

import java.util.List;
import java.util.Map;

public class AmazonTest extends BaseTest {

    @Test
    public void extractAndVerifyAmazonProduct() throws Exception {
        HomePage home = new HomePage(driver);
        home.searchFor("wireless headphones");

        SearchResultsPage results = new SearchResultsPage(driver);
        results.applyFourStarFilter();

        List<Map<String, String>> products = results.extractValidProducts(50, 200);
        CSVUtils.writeCSV(products, "products.csv");

        if (!products.isEmpty()) {
            Map<String, String> first = products.get(0);
            results.clickFirstProduct();
            ProductDetailsPage details = new ProductDetailsPage(driver);
            details.verifyProductDetails(first);
        }
    }
}
