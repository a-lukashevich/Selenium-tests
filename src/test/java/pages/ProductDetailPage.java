package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {

    // Constructor
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    //WebElements
    By buyNewBy = By.xpath("//*[contains(text(), 'Buy new')]");
    By selectQtyBy = By.id("quantity");
    By addToCartBy = By.id("add-to-cart-button");
    By cartValueBy = By.id("nav-cart-count");
    By cartLinkBy = By.id("nav-cart");

    // Page Methods

    // Click on Buy new
    public ProductDetailPage clickBuyNew() {
       click(buyNewBy);
       return this;
    }

    // Select Quantity
    public ProductDetailPage selectQty(String value) {
        selectDropdownByValue(selectQtyBy, value);
        return this;
    }

    // Add to cart
    public ProductDetailPage addToCart() {
        click(addToCartBy);
        return this;
    }

    // Get quantity from Cart Icon
    public String getQtyValCartIcon() {
        return getText(cartValueBy);
    }

    // Verify quantity on the Cart icon
    public ProductDetailPage verifyQtyInCartIcon(String expectedQty) {
        assertEqualsByText(expectedQty, cartValueBy);
        return this;
    }

}