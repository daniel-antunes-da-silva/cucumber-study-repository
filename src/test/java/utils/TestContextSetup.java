package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
//    public WebDriver driver = new ChromeDriver();
    public String landingPageProduct;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup(PageObjectManager pageObjectManager) throws IOException {
        this.pageObjectManager = pageObjectManager;
        testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
