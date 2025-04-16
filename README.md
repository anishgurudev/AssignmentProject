# Amazon Product Scraper (Selenium Java Framework)

This project automates product search and filtering on [Amazon](https://www.amazon.com) using **Java + Selenium WebDriver**. It extracts valid product data (based on price and rating filters), saves the results to a CSV file, and verifies the product details on the product page.

---

## Features
- Page Object Model (POM) structure
- Cross-browser support (Chrome and Firefox)
- Dynamic content handling with explicit waits
- CSV generation of filtered product data
- Data validation of title, price, rating, reviews
- Modular locator classes for easy XPath maintenance
- Error handling and clean code practices

---

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- WebDriverManager

---

## Folder Structure
```
ecomerce-framework/
│
├── base/                  # Test base class
│   └── BaseTest.java
│
├── tests/                 # Test cases
│   └── FlipkartTest.java
│
├── pages/                 # Page classes (POM)
│   ├── HomePage.java
│   ├── SearchResultsPage.java
│   └── ProductDetailsPage.java
│
├── locators/              # Locator definitions (single responsibility)
│   ├── HomePageLocators.java
│   ├── SearchResultsPageLocators.java
│   └── ProductDetailsPageLocators.java
│
├── utils/                 # Utilities
│   ├── DriverFactory.java
│   └── CSVUtils.java
└── products.csv           # Generated CSV file
```

---

## Prerequisites
- JDK 8+
- Maven
- Internet connection (for WebDriverManager)

---

## Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/anishgurudev/AssignmentProject.git
cd AssignmentProject
```

### 2. Add `pom.xml` with dependencies
(Ask if you need it generated)

### 3. Run with Maven
```bash
mvn clean test
```

Or use TestNG XML:
```xml
<suite name="Amazon Product Scraper Suite">

    <!-- Run with Chrome Browser -->
    <test name="Amazon Chrome Test">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.AmazonTest"/>
        </classes>
    </test>

    <!-- Run with Firefox Browser -->
    <test name="Amazon Firefox Test">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="tests.AmazonTest"/>
        </classes>
    </test>

</suite>
```

---

## Output
- **products.csv**: Contains product title, price, rating, and number of reviews.
- **Console Logs**: Shows progress and validations.

---

## Author
**Anish Kumar**  |  Lead Software Test Engineer

For questions, raise an issue or connect on [9036371870](9036371870).

---

## Contributions
Pull requests are welcome. For major changes, please open an issue first.

---

## License
This project is licensed under the License.
