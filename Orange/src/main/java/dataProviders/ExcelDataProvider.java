package dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public final class ExcelDataProvider {

	private ExcelDataProvider() {}
	
	@DataProvider(name="loginData")
	public static Object[] provideLoginData() throws IOException {
		return ExcelUtils.getData("loginData");
	}
}
