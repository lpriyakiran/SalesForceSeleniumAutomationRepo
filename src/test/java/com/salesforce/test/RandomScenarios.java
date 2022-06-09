package com.salesforce.test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;

public class RandomScenarios extends BaseTest{
	
	public static void TC33_Name_Verification() {
		Login.login();
		Login.login();
		waitUntillocatedById("userNavButton");
		Home.goToHomeTab();
	}

}
