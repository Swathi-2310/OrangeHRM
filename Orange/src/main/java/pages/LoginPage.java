package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public final class LoginPage extends BasePage{

	private final By usernameTextField = By.name("username");
	private final By passwordTextField = By.name("password");
	private final By clickLoginBtn = By.xpath("//button[normalize-space()='Login']");
	
	public LoginPage enterUsername(String username) {
		sendKeys(usernameTextField, username, WaitStrategy.PRESENCE);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		sendKeys(passwordTextField, password, WaitStrategy.PRESENCE);
		return this;
	}
	
	public HomePage clickLogin() {
		click(clickLoginBtn, WaitStrategy.CLICKABLE);
		return new HomePage();
	}
	
}
