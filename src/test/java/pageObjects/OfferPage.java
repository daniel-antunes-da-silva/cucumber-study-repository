package pageObjects;

import org.openqa.selenium.By;
import utils.TestContextSetup;

public class OfferPage {
    By search = By.id("search-field");
    By productName = By.xpath("//table[@class='table table-bordered']//tr/td");
    TestContextSetup testContextSetup;

    public OfferPage(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    public void searchItem(String name) {
        this.testContextSetup.driver.findElement(search).sendKeys(name);
    }

    public void getSearchText() {
        this.testContextSetup.driver.findElement(search).getText();
    }

    public String getProductName() {
        return this.testContextSetup.driver.findElement(productName).getText();
    }
}
