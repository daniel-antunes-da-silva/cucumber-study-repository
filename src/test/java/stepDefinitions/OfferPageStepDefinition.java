package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.OfferPage;
import utils.TestContextSetup;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OfferPageStepDefinition {
    public String offerPageProduct;
    TestContextSetup testContextSetup;
    public String landingPageProduct;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for shortname {string} in offers page to check if product exist")
    public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortname) throws InterruptedException {
        this.switchToOfferPage();
        OfferPage offerPage = this.testContextSetup.pageObjectManager.getOfferPage();
        offerPage.searchItem(shortname);
        Thread.sleep(2000);
        offerPage.findProductName();
        offerPageProduct = offerPage.getProductName();
        assertTrue(offerPageProduct.startsWith(shortname));
    }

    public void switchToOfferPage() {
        this.testContextSetup.genericUtils.SwitchWindowToOfferPage();
    }

    @Then("the product name at the offer page is the same in the landing page")
    public void theProductNameAtTheOfferPageIsTheSameInTheLandingPage() {
        this.landingPageProduct = this.testContextSetup.pageObjectManager.landingPage.getProductName().split("-")[0].trim();
        assertEquals(landingPageProduct, offerPageProduct);
    }
}
