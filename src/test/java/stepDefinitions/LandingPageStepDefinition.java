package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void userIsOnGreenCartLandingPage() {
        landingPage = this.testContextSetup.pageObjectManager.getLandingPage();
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortname) throws InterruptedException {
        this.landingPage.searchItem(shortname);
        Thread.sleep(2000);
        this.testContextSetup.landingPageProduct = this.landingPage.getProductName().split("-")[0].trim();
        assertTrue(this.testContextSetup.landingPageProduct.startsWith(shortname));
    }

}
