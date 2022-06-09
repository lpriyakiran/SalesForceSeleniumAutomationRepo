package com.salesforce.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;
import com.salesforce.utilities.CommonUtilities;

public class Login extends BaseTest{
	
	protected static String userName= CommonUtilities.getApplicationProperty("username");
	protected static String password= CommonUtilities.getApplicationProperty("password");
	
	public static void login() {
		waitUntillocatedById("username");
		WebElement username = driver.findElement(By.id("username"));
		WebElement passwrd = driver.findElement(By.id("password"));
		username.sendKeys(userName);
		passwrd.sendKeys(password);
		loginClick();
	}
	
	public static void login(String user, String pass) {
		WebElement username = driver.findElement(By.id("username"));
		waitUntilVisible(username);
		username.sendKeys(user);
		WebElement passwrd = driver.findElement(By.id("password"));
		passwrd.sendKeys(pass);
		loginClick();
	}
	
	public static void loginClick() {
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickButton(loginButton);
	}
	
	public static void emptyPasswordLogin() {
		WebElement username = driver.findElement(By.id("username"));
		waitUntilVisible(username);
		username.sendKeys(userName);
		WebElement passwrd = driver.findElement(By.id("password"));
		clearElement(passwrd);
		if(passwrd.getText().isBlank()) 
			System.out.println("Password field has been cleared.");
		else
			System.out.println("Password field has not been cleared.");
		loginClick();
	}
	
	public static void loginWithRememberMe() {
		WebElement username = driver.findElement(By.id("username"));
		waitUntilVisible(username);
		username.sendKeys(userName);
		WebElement passwrd = driver.findElement(By.id("password"));
		passwrd.sendKeys(password);
		WebElement rememberCheckBox = driver.findElement(By.id("rememberUn"));
		rememberCheckBox.click();
		loginClick();
	}
	
	public static boolean checkLoginErrorMsg() {
		WebElement errorMsg = driver.findElement(By.id("error"));
		return errorMsg.isDisplayed();
	}
	
	public static void clickForgotPassword() {
		WebElement username = driver.findElement(By.id("username"));
		waitUntilVisible(username);
		WebElement forgotPassword = driver.findElement(By.id("forgot_password_link"));
		clickElement(forgotPassword);
	}
	
	public static String checkEmptyPasswordErrorMsg() {
		waitUntilLocatedBy(By.xpath("//div[@id='error']"));
		WebElement message = driver.findElement(By.xpath("//div[@id='error']"));
		return message.getText();
	}
	
	public static String checkUsernameRemember() {
		WebElement rememberName = driver.findElement(By.id("idcard-identity"));
		waitUntilVisible(rememberName);
		return rememberName.getText();
	}
	
	public static void forgotPasswordProcess() {
		By locator = By.xpath("//h1[@id='header'][text()='Forgot Your Password']");
		waitUntilLocatedBy(locator);
		//WebElement frgtPassword = driver.findElement(locator);
		//waitUntilVisible(frgtPassword);
		
		WebElement enterUsername = driver.findElement(By.xpath("//input[@type='email']"));
		enterUsername.sendKeys(userName);
		WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
		clickButton(continueButton);
		
		WebElement returnToLoginBtn = driver.findElement(By.xpath("//a[text()='Return to Login']"));
		waitUntilVisible(returnToLoginBtn);
	}
	
	public static boolean checkForgotPwdEmailMsg() {
		WebElement checkEmailmsg = driver.findElement(By.xpath("//h1[@id='header'][text()='Check Your Email']"));
		return checkEmailmsg.isDisplayed();
	}
}
