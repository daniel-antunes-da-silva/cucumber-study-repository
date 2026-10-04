package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextSetup;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void userIsOnGreenCartLandingPage() {
        this.testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortname) throws InterruptedException {
        this.testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        Thread.sleep(2000);
        this.testContextSetup.landingPageProduct = this.testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        assertTrue(this.testContextSetup.landingPageProduct.startsWith(shortname));
    }

}
