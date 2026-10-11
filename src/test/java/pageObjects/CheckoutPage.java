package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    By cartBag = By.className("cart-icon");
    By checkoutButton = By.xpath("//button[contains(text(), 'TO CHECKOUT')]");
    By promoButton = By.cssSelector(".promoBtn");
    By placeOrderButton = By.xpath("//button[contains(text(), 'Place Order')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public Boolean verifyPromoBtn() {
        return driver.findElement(promoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrder() {
        return driver.findElement(placeOrderButton).isDisplayed();
    }


}
