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

public class OfferPageStepDefinition {
    String offerPageProduct;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for shortname {string} in offers page to check if product exist")
    public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortname) {
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortname);
        offerPageProduct = testContextSetup.driver.findElements(
                By.xpath("//table[@class='table table-bordered']//tr/td")).get(0).getText();
        assertTrue(offerPageProduct.startsWith(shortname));
    }

    @Then("the product name at the offer page is the same in the landing page")
    public void theProductNameAtTheOfferPageIsTheSameInTheLandingPage() {
        assertEquals(this.testContextSetup.landingPageProduct, offerPageProduct);
    }
}
