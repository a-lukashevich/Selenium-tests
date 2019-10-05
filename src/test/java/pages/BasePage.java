package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    // Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    // Click Method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    // Enter text
    public void enterText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    // Get text
    public String getText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    // Select dropdown by visible Text
    public void selectDropdownByText(By elementBy, String text) {
        WebElement select = driver.findElement(elementBy);
        Select dropdownSelect = new Select(select);
        dropdownSelect.selectByVisibleText(text);
    }

    // Select dropdown by value
    public void selectDropdownByValue(By elementBy, String value) {
        WebElement select = driver.findElement(elementBy);
        Select dropdownSelect = new Select(select);
        dropdownSelect.selectByValue(value);
    }

    //Assert by text of the Web Element
    public void assertEqualsByText(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(expectedText, getText(elementBy));
    }
}
