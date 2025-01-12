# **UI and API Testing with Selenium, RestAssured, and Cucumber**

This Maven project demonstrates UI testing with **Selenium** and API testing with **RestAssured** using the **Cucumber** framework. It validates both the functionality of a web application and an API.

---

## **Project Structure**

```
src
└── main
│   └── java
│
└── test
    ├── java
    │   ├── stepDefinitions
    │   │   ├── UITestSteps.java
    │   │   └── APITestSteps.java
    │   └── runner
    │       └── TestRunner.java
    └── resources
        └── features
            ├── UITest.feature
            └── APITest.feature
```

- **Feature Files**: Located in `src/test/resources/features/`
  - `UITest.feature`: Describes the UI test scenario in Gherkin syntax.
  - `APITest.feature`: Describes the API test scenario in Gherkin syntax.

- **Step Definitions**: Located in `src/test/java/stepDefinitions/`
  - `UITestSteps.java`: Implements the steps for UI testing.
  - `APITestSteps.java`: Implements the steps for API testing.

- **Test Runner**: `src/test/java/runner/TestRunner.java`  
  Configures and runs the Cucumber tests.

---

## **Prerequisites**

1. **Java**: Ensure Java 8 or higher is installed.
   ```bash
   java -version
   ```
2. **Maven**: Ensure Maven is installed and added to your system's PATH.
   ```bash
   mvn -version
   ```
3. **WebDriver**: ChromeDriver should be available for Selenium.
4. **IDE**: Use an IDE like IntelliJ IDEA or Eclipse for easy management.

---

## **How to Set Up the Project**

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Open the project in your IDE.
3. Update Maven dependencies:
   ```bash
   mvn clean install
   ```

---

## **How to Run the Tests**

### Using IDE:
1. Open `TestRunner.java`.
2. Right-click and select **Run**.

### Using Command Line:
Run the following command:
```bash
mvn test
```

---

## **Feature Files**

### `UITest.feature`

Describes the Selenium-based UI test scenario:

```gherkin
Feature: eBay UI Test

  Scenario: Add item to cart
    Given I open the eBay homepage
    When I search for "book"
    And I select the first suggestion
    And I add the first item to the cart
    Then I should see one item in the cart
```

### `APITest.feature`

Describes the RestAssured-based API test scenario:

```gherkin
Feature: Verify Coindesk API

  Scenario: Validate BPI data and descriptions
    Given I send a GET request to "/v1/bpi/currentprice.json"
    Then I should get a 200 status code
    And the response should contain BPIs "USD", "GBP", and "EUR"
    And "GBP" description should be "British Pound Sterling"
```

---

## **Expected Output**

### UI Test:
1. Open eBay homepage.
2. Search for "book."
3. Select the first suggestion and add the first item to the cart.
4. Verify that one item is added to the cart.

### API Test:
1. Validate the API response returns a 200 status code.
2. Check that the response contains "USD," "GBP," and "EUR" in the `bpi` object.
3. Ensure the `GBP` description matches "British Pound Sterling."

Results are displayed in the console and saved as a report in `target/cucumber-reports.html`.

---

## **Dependencies**

This project uses the following Maven dependencies:

- **Selenium**: For UI testing.
- **RestAssured**: For API testing.
- **Cucumber**: For BDD (Behavior-Driven Development).
- **JUnit**: For test execution.
- **WebDriver Manager**: To manage browser drivers.
- **JSON Path**: For parsing and verifying JSON responses.

Check the full list of dependencies in the `pom.xml` file.

---

## **Contributing**

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your message here"
   ```
4. Push the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

---

## **License**

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to customize this README as needed!

