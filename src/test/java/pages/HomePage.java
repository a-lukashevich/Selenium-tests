package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Costructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Page Variables
    String baseURL = "https://www.amazon.com";

    // Web Elements
    By categoryDropdownBy = By.id("searchDropdownBox");
    By searchBoxBy = By.id("twotabsearchtextbox");
    By searchButtonBy = By.id("nav-search-submit-text");

    // Page Methods
    // Go to HomePage
    public HomePage goToAmazon () {
        driver.get(baseURL);
        return this;
    }

    // Choose category
    public HomePage selectCategory(String category) {
        selectDropdownByText(categoryDropdownBy, category);
        return this;
    }

    // Search
    public HomePage searchProduct(String productName) {
        enterText(searchBoxBy, productName);
        click(searchButtonBy);
        return this;
    }

    // Go to PDP page
    public ProductDetailPage goToPDP(String bookName) {
        By productBy = By.partialLinkText(bookName);
        click(productBy);
        return new ProductDetailPage(driver);
    }

}
