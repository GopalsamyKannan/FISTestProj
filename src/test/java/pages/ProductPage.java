package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@id, 'atcBtn_btn')]//span[text()='Add to cart']") // Add to cart button
    WebElement addToCartButton;

    @FindBy(id = "gh-cart-n")
    WebElement cartCount;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void addToCart() {
        //addToCartButton.click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Falling back to JavaScript click due to: " + e.getMessage());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }
    }

    public String getCartCount() {
        return cartCount.getText();
    }
}
