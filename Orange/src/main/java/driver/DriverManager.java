package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor to prevent instantiation
    private DriverManager() {}

    public static void initDriver(BrowserType browser) {
        if (driver.get() == null) {
            switch (browser) {
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver.set(new ChromeDriver(chromeOptions));
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver.set(new FirefoxDriver(firefoxOptions));
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver.set(new EdgeDriver(edgeOptions));
                }
                default -> throw new IllegalStateException("Unexpected browser: " + browser);
            }
            getDriver().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
    	
    	 if (driver.get() == null) {
    	        throw new IllegalStateException("WebDriver not initialized. Call initDriver() first.");
    	    }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}	
