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

Results are displayed in the console and saved as a report in `target/cucumber-reports.html`.

---

## **License**

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to customize this README as needed!

