package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class OfferPage {
    By search = By.id("search-field");
    By productName = By.xpath("//table[@class='table table-bordered']//tr/td");
    WebDriver driver;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name) {
        this.driver.findElement(search).sendKeys(name);
    }

    public void getSearchText() {
        this.driver.findElement(search).getText();
    }

    public String getProductName() {
        return this.driver.findElement(productName).getText();
    }
}
