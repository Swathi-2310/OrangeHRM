package pages;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;

import enums.WaitStrategy;
import reports.ExtentLogger;

public final class HomePage extends BasePage {

    private static final String sideMenuXPath = "//span[normalize-space()='%s']";
    private static final String headerXPath = "//h6[normalize-space()='%s']";
	
	public void menutoHeaderValidation() {
		
		Map<String, String> menuToHeader = new LinkedHashMap<>();
		menuToHeader.put("Admin", "Admin");
		menuToHeader.put("PIM", "PIM");
		menuToHeader.put("Leave", "Leave");
		menuToHeader.put("Time", "Time");
		menuToHeader.put("Recruitment", "Recruitment");
		menuToHeader.put("My Info", "PIM");
		menuToHeader.put("Performance", "Performance");
		menuToHeader.put("Dashboard", "Dashboard");
		menuToHeader.put("Directory", "Directory");
		menuToHeader.put("Maintenance", "Maintenance");
		menuToHeader.put("Claim", "Claim");
		menuToHeader.put("Buzz", "Buzz");
		
		for(Map.Entry<String, String> entry : menuToHeader.entrySet()) {
			
			String sideMenu = entry.getKey();
			String expectedHeader = entry.getValue();
			
			By menuLocator = By.xpath(String.format(sideMenuXPath, sideMenu));
			By headerLocator = By.xpath(String.format(headerXPath, expectedHeader));
			
			click(menuLocator, WaitStrategy.CLICKABLE);
			
			if(menuLocator.equals(headerLocator)) {
				ExtentLogger.info("Header Verification Passed :"+headerLocator);
			}else {
				ExtentLogger.info("Header Verification Failed :"+headerLocator);
			}
		}
		
	}
	
}
