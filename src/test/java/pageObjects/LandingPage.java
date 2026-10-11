package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private final By search = By.xpath("//input[@type='search']");
    private final By productName = By.cssSelector("h4.product-name");
    private final By increment = By.cssSelector("a.increment");
    private final By cart = By.cssSelector(".product-action button");
    private String landingPageProductName;
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

    public void findProductName() {
        this.landingPageProductName = this.driver.findElements(productName).get(0).getText();
    }

    public String getProductName() {
        return this.landingPageProductName;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void incrementQuantity(int quantity) {
        int i = quantity;
        WebElement incrementButton = driver.findElement(increment);
        while (i > 0) {
            incrementButton.click();
            i --;
        }
    }

    public void addToCart() {
        driver.findElement(cart).click();
    }
}
