package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Set;

public class APITestSteps {

    Response response;

    @Given("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        RestAssured.baseURI = "https://api.coindesk.com";
        response = RestAssured.get(endpoint);
    }

    @Then("I should get a {int} status code")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals("Status code mismatch!", statusCode, response.getStatusCode());
    }

    @Then("the response should contain BPIs {string}, {string}, and {string}")
    public void verifyBPIs(String bpi1, String bpi2, String bpi3) {
        JsonPath jsonPath = response.jsonPath();
        Set<String> bpiKeys = jsonPath.get("bpi.keySet()");
        System.out.println("BPI Keys: "+bpiKeys.toString());
        Assert.assertTrue("Response missing BPI: " + bpi1, bpiKeys.contains(bpi1));
        Assert.assertTrue("Response missing BPI: " + bpi2, bpiKeys.contains(bpi2));
        Assert.assertTrue("Response missing BPI: " + bpi3, bpiKeys.contains(bpi3));
    }

    @Then("{string} description should be {string}")
    public void verifyDescription(String bpi, String expectedDescription) {
        JsonPath jsonPath = response.jsonPath();
        String actualDescription = jsonPath.getString("bpi." + bpi + ".description");
        System.out.println("Description is: "+actualDescription);
        Assert.assertEquals("Description mismatch for " + bpi, expectedDescription, actualDescription);
    }
}
