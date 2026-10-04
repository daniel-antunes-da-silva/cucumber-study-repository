package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class LandingPage {
    private final By search = By.xpath("//input[@type='search']");
    private final By productName = By.cssSelector("h4.product-name");
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name) {
        this.driver.findElement(search).sendKeys(name);
    }

    public void getSearchText() {
        this.driver.findElement(search).getText();
    }

    public String getProductName() {
        return this.driver.findElements(productName).get(0).getText();
    }
}
