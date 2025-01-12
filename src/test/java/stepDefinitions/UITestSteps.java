package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Set;

public class UITestSteps {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;

    @Given("I navigate to the URL")
    public void navigateTo() {

        String url = ConfigReader.getProperty("url"); // Fetch URL from config.properties
        String browser = ConfigReader.getProperty("browserName");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
    }

    @When("I search for {string}")
    public void searchItem(String item) {
        homePage.enterSearchTerm(item);
    }

    @And("I select the first suggestion")
    public void selectFirstSuggestion() {
        homePage.selectFirstSuggestion();
    }

    @And("I add the first item to the cart")
    public void addItemToCart() throws InterruptedException {

        searchResultsPage.clickFirstItem();

        // Switch to the new tab
        Set<String> allWindows = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();
        allWindows.remove(mainWindow);
        driver.switchTo().window(allWindows.iterator().next());

        productPage.addToCart();
    }

    @Then("I should see one item in the cart")
    public void verifyCartItem() throws InterruptedException {

        String cartCount = productPage.getCartCount();
        if (cartCount.contains("1")) {
            System.out.println("Item successfully added to the cart.");
        } else {
            System.out.println("Item was not added to the cart.");
        }

        driver.quit();
    }
}
