package com.salesforce.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.accounts.AccountsHome;
import com.salesforce.pages.accounts.MergeAccounts;
import com.salesforce.pages.accounts.NewAccounts;
import com.salesforce.pages.accounts.UnsavedReport;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;
import com.salesforce.pages.views.CreateNewView;
import com.salesforce.pages.views.EditView;

public class Account extends BaseTest{
	@Test
	public static void TC10_Create_Account() {
		Login.login();
		waitUntillocatedById("userNavButton");
		Home.goToAccountsTab();
		Home.closeDialog();
		//Create new account
		AccountsHome.clickOnNewAccount();
		NewAccounts.createNewAccount("Ammu2");
		waitUntilLocatedBy(By.xpath("//h2[contains(text(),'Account Detail')]"));
	}
	
	@Test
	public static void TC11_Create_New_View() {
		Login.login();
		waitUntillocatedById("userNavButton");
		Home.goToAccountsTab();
		Home.closeDialog();
		AccountsHome.creatNewView();
		CreateNewView.enterNewView("ABCD", "XYZ", true);
		waitUntilLocatedBy(By.xpath("//input[@class='btn'][@title='New Account']"));
	}
	
	@Test
	public static void TC12_Edit_View() {
		Login.login();
		waitUntillocatedById("userNavButton");
		Home.goToAccountsTab();
		Home.closeDialog();
		AccountsHome.selectView();
		AccountsHome.editView();
		EditView.editView();
		waitUntilTitle("Accounts ~ Salesforce - Developer Edition");
	}
	
	@Test
	public static void TC13_Merge_Accounts() {
		Login.login();
		waitUntillocatedById("userNavButton");
		Home.goToAccountsTab();
		Home.closeDialog();
		AccountsHome.mergeAccounts();
		MergeAccounts.searchAccount();
		MergeAccounts.selectAndMerge();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Accounts']"));
	}
	
	@Test
	public static void TC14_Create_Acc_Report() {
		Login.login();
		waitUntillocatedById("userNavButton");
		Home.goToAccountsTab();
		Home.closeDialog();
		AccountsHome.accountReport();
		UnsavedReport.generateReport();
	}
	
}
