package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    WebDriver driver;

    @FindBy(xpath = "(//div[contains(@class, 's-item__info')]/a[@target='_blank' and @class='s-item__link']//span[@role='heading'])[3]") // First item
    WebElement firstItem;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstItem() {
        firstItem.click();
    }
}
