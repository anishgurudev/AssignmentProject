package base;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import org.testng.annotations.*; // → package does not exist error

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        driver = DriverFactory.getDriver(browser);
        driver.get("https://www.amazon.com");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
