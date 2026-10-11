package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    public String landingPageProduct;
    LandingPage landingPage;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }


    @And("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }

    @Then("user proceeds to checkout and validate the {string} items in checkout page")
    public void userProceedsToCheckoutAndValidateTheItemsInCheckoutPage(String productName) throws InterruptedException {
        checkoutPage.checkoutItems();
        Thread.sleep(2000);
    }

    @And("verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }

}
