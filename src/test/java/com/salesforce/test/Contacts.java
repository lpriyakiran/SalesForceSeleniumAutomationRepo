package com.salesforce.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.contacts.ContactsHome;
import com.salesforce.pages.contacts.NewContact;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;
import com.salesforce.pages.views.CreateNewView;

public class Contacts extends BaseTest{
	@Test
	public static void TC25_Create_New_Contact() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.newContact();
		NewContact.addNewContact("LM", "Ammu2");	
	}
	
	@Test
	public static void TC26_Create_New_View_In_Contact() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.creatNewView();
		CreateNewView.enterNewView("views", "Ammu", true);
		waitUntilLocatedBy(By.xpath("//input[@class='btn'][@title='Add to Campaign']"));
	}
	
	@Test
	public static void TC27_Recently_Created_Contact() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.recentSelection();
		ContactsHome.selectRecentlyCreated();
	}
	
	@Test
	public static void TC28_My_Contact() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.selectView();
		ContactsHome.selectMyContact();
	}
	
	@Test
	public static void TC29_View_A_Contact() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.selectView();
		ContactsHome.selectMyContact();
	}
	
	@Test
	public static void TC30_Create_New_View_Error_Msg() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.creatNewView();
		CreateNewView.enterNewView("", "EFGH", true);
		
		String expectedMsg = "Error: You must enter a value";
		String actualMsg = CreateNewView.newViewErrorMsg();
		System.out.println(actualMsg);
		
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}
	
	@Test
	public static void TC31_Cancel_New_View() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.creatNewView();
		CreateNewView.enterNewView("ABCD", "EFGH", false);
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contacts']"));
		
	}
	
	@Test
	public static void TC32_Save_And_New() {
		Login.login();
		Home.goToContactsTab();
		Home.closeDialog();
		ContactsHome.newContact();
		NewContact.saveAndNewContact("Indian", "Global Media");
	}
	
}
