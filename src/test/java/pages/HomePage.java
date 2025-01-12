package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "gh-ac") // Search box
    WebElement searchBox;

    @FindBy(id = "gh-btn") // Search button
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(@id, 'ui-id') and @role='option']") // First suggestion
    WebElement firstSuggestion;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchTerm(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public void selectFirstSuggestion() {
        firstSuggestion.click();
    }
}
