package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class CartTest extends BaseTest{
    @Test (priority = 0)
    public void shouldContainExpectedAmountOfItemsInCart() throws InterruptedException {
        // Page Installation
        HomePage homePage = new HomePage(driver);

        // Page Methods
        homePage.goToAmazon()
                .selectCategory("Books")
                .searchProduct("Java")
                .goToPDP("Effective Java")
                .clickBuyNew()
                .selectQty("1")
                .addToCart()
                .verifyQtyInCartIcon("1");
    }
}
