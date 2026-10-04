package utils;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
    WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void SwitchWindowToOfferPage() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }
}
