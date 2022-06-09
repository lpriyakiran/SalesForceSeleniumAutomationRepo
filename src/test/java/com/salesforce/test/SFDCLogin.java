package com.salesforce.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;
import com.salesforce.utilities.CommonUtilities;

public class SFDCLogin extends BaseTest{
	
	@Test
	public static void emptyPasswordError() {
		Login.emptyPasswordLogin();
		String expectedErrorMsg = "Please enter your password.";
		String errorMsg = Login.checkEmptyPasswordErrorMsg();
		Assert.assertEquals(errorMsg, expectedErrorMsg);
	}
	
	@Test
	public static void loginToSFDC() {
		Login.login();
		waitUntilTitle("Home Page ~ Salesforce - Developer Edition");
	}
	
	@Test
	public static void checkRememberMe() throws InterruptedException {
		Login.loginWithRememberMe();
		waitUntillocatedById("userNavButton");
		Home.userNavigation();
		Home.logout();
		Thread.sleep(3000);
		String expected = CommonUtilities.getApplicationProperty("username");
		String actual = Login.checkUsernameRemember();
		Assert.assertEquals(actual, expected);		
	}
	
	@Test
	public static void forgotPassword() {
		Login.clickForgotPassword();
		Login.forgotPasswordProcess();
		boolean actual = Login.checkForgotPwdEmailMsg();
		Assert.assertEquals(actual, true);
	}
	
	@Test
	public static void loginErrorMessage() {
		Login.login("123", "22131");
		boolean actual = Login.checkLoginErrorMsg();
		Assert.assertEquals(actual, true);
	}
}
