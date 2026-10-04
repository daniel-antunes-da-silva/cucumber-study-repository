package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup, LandingPage landingPage) {
        this.testContextSetup = testContextSetup;
        this.landingPage = landingPage;
    }

    @Given("User is on GreenCart Landing page")
    public void userIsOnGreenCartLandingPage() {
        this.testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortname) throws InterruptedException {
        this.landingPage.searchItem(shortname);
        Thread.sleep(2000);
        this.testContextSetup.landingPageProduct = this.landingPage.getProductName().split("-")[0].trim();
        assertTrue(this.testContextSetup.landingPageProduct.startsWith(shortname));
    }

}
