package tests;

import java.util.Map;

import org.testng.annotations.Test;

import dataProviders.ExcelDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void login(Map<String, String> data) {
		new LoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin();
	}
}