package factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
		// Prevent instantiation
	}

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator) {
		WebDriver driver = DriverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitWait()));

		return switch (waitStrategy) {
		case CLICKABLE -> wait.until(ExpectedConditions.elementToBeClickable(locator));
		case VISIBLE -> wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		case PRESENCE -> wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		case NONE -> driver.findElement(locator);
		};
	}
}