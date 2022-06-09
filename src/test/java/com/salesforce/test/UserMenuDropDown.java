package com.salesforce.test;

import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;

public class UserMenuDropDown extends BaseTest{
	
	@Test
	public static void TC05() {
		Login.login();
		Home.goToUserMenu();
		Home.checkUserMenuItems();
	}
	
	@Test
	public static void TC06() throws Exception {
		Login.login();
		Home.goToUserMenu();
		Home.myProfile();
		Home.myProfileEdit();
		switchToFrame(2);
		Home.editProfile();
		switchToFrame(1);
		Home.sharePost();
		Home.fileLink();
		Home.addPhoto();
	}
	
	@Test
	public static void TC08_DeveloperConsole() throws Exception {
		Login.login();
		Home.goToUserMenu();
		Home.devConsole();
		Home.devConsoleWindow();
	}
	
	@Test
	public static void TC09_Logout() {
		Login.login();
		Home.goToUserMenu();
		Home.logout();
		waitUntillocatedById("Login");
	}
	

}
