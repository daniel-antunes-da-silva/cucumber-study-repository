package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream("src//test//resources//global.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String url = properties.getProperty("QAUrl");

        if (driver == null) {
            if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            driver.get(url);
        }
        return driver;
    }
}
