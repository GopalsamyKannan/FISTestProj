package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Set;

public class UITestSteps {
    WebDriver driver;
    WebDriverWait wait;

    //@Given("I navigate to {string}")
    @Given("I navigate to the URL")
    public void navigateTo() {

        //String browser = System.getProperty("browser", "chrome");

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I search for {string}")
    public void searchItem(String item) {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys(item);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-id-1' and @role='listbox']")));
    }

    @And("I select the first suggestion")
    public void selectFirstSuggestion() {
        driver.findElement(By.xpath("//*[contains(@id, 'ui-id') and @role='option']")).click();
    }

    @And("I add the first item to the cart")
    public void addItemToCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 's-item__info')]/a[@target='_blank' and @class='s-item__link']//span[@role='heading'])[3]")));
        driver.findElement(By.xpath("(//div[contains(@class, 's-item__info')]/a[@target='_blank' and @class='s-item__link']//span[@role='heading'])[3]")).click();
        Thread.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();
        String mainWindowHandle = driver.getWindowHandle();
        allWindows.remove(mainWindowHandle);
        String newWindowHandle = allWindows.iterator().next();
        driver.switchTo().window(newWindowHandle);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@id, 'atcBtn_btn')]//span[text()='Add to cart']")));
        driver.findElement(By.xpath("//a[contains(@id, 'atcBtn_btn')]//span[text()='Add to cart']")).click();
    }

    @Then("I should see one item in the cart")
    public void verifyCartItem() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gh-cart-n")));
        String noOfItemsInCart = driver.findElement(By.id("gh-cart-n")).getText();
        if (noOfItemsInCart.contains("1")) {
            System.out.println("Item successfully added to the cart.");
        } else {
            System.out.println("Item was not added to the cart.");
        }
        driver.quit();
    }
}
