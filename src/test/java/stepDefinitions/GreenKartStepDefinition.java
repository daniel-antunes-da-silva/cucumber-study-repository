package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GreenKartStepDefinition {
    WebDriver driver = new ChromeDriver();
    String landingPageProduct;
    String offerPageProduct;

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
//        System.setProperty("webdriver.chrome.driver", )
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extrated actual name of product")
    public void user_searched_with_shortname_and_extrated_actual_name_of_product(String shortname) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        Thread.sleep(2000);
        landingPageProduct = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        assertTrue(landingPageProduct.startsWith(shortname));
    }

    @Then("user searched for shortname {string} in offers page to check if product exist")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortname) {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys(shortname);
        offerPageProduct = driver.findElements(
                By.xpath("//table[@class='table table-bordered']//tr/td")).get(0).getText();
        assertTrue(offerPageProduct.startsWith(shortname));
    }

    @Then("the product name are the same in the two pages")
    public void theProductNameAreTheSameInTheTwoPages() {
        assertEquals(landingPageProduct, offerPageProduct);
    }
}
