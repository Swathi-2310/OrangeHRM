package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;

public class BasePage {

    protected void click(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.click();
    }

    protected void sendKeys(By locator, String value, WaitStrategy waitStrategy) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Input value cannot be null or empty");
        }
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.clear(); // optional: clear existing text
        element.sendKeys(value);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
    
    protected boolean isDisplayed(By locator, WaitStrategy waitStrategy) {
    	WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
    	return element.isDisplayed();
    }
}