package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class HomeTest extends BaseTest {
	
	@Test
	public void testModuleNavigation() {
		
		new HomePage().menutoHeaderValidation();
	}

}
