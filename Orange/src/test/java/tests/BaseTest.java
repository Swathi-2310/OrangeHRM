package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import driver.DriverManager;
import enums.BrowserType;
import listeners.TestListener;
import utils.PropertyUtils;

@Listeners(TestListener.class)
public class BaseTest {
	
	protected BaseTest() {}
	
	@BeforeSuite
	public void setUp() {
		DriverManager.initDriver(BrowserType.CHROME);
		DriverManager.getDriver().get(PropertyUtils.get("url"));

	}
	
	@AfterSuite
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
