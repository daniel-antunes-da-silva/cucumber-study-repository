package pageObjects;

import org.openqa.selenium.By;
import utils.TestContextSetup;

public class LandingPage {
    private final By search = By.xpath("//input[@type='search']");
    private final By productName = By.cssSelector("h4.product-name");
    TestContextSetup testContextSetup;

    public LandingPage(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    public void searchItem(String name) {
        this.testContextSetup.driver.findElement(search).sendKeys(name);
    }

    public void getSearchText() {
        this.testContextSetup.driver.findElement(search).getText();
    }

    public String getProductName() {
        return this.testContextSetup.driver.findElements(productName).get(0).getText();
    }
}
