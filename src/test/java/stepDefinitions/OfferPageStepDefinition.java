package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OfferPageStepDefinition {
    String offerPageProduct;
    TestContextSetup testContextSetup;
    OfferPage offerPage;

    public OfferPageStepDefinition(TestContextSetup testContextSetup, OfferPage offerPage) {
        this.testContextSetup = testContextSetup;
        this.offerPage = offerPage;
    }

    @Then("user searched for shortname {string} in offers page to check if product exist")
    public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortname) {
        this.switchToOfferPage();
        this.offerPage.searchItem(shortname);
        offerPageProduct = this.offerPage.getProductName();
        assertTrue(offerPageProduct.startsWith(shortname));
    }

    public void switchToOfferPage() {
        this.testContextSetup.genericUtils.SwitchWindowToOfferPage();
    }

    @Then("the product name at the offer page is the same in the landing page")
    public void theProductNameAtTheOfferPageIsTheSameInTheLandingPage() {
        assertEquals(this.testContextSetup.landingPageProduct, offerPageProduct);
    }
}
