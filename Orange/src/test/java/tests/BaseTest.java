package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import driver.DriverManager;
import enums.BrowserType;
import listeners.TestListener;
import utils.PropertyUtils;

@Listeners(TestListener.class)
public class BaseTest {
	
	protected BaseTest() {}
	
	@BeforeMethod
	public void setUp() {
		DriverManager.initDriver(BrowserType.CHROME);
		DriverManager.getDriver().get(PropertyUtils.get("url"));

	}
	
	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
