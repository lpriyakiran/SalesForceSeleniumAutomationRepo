package com.salesforce.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.leads.LeadsPage;
import com.salesforce.pages.leads.NewLeads;
import com.salesforce.pages.login.Login;

public class Leads extends BaseTest{
	
	@Test
	public static void TC20_Leads_Tab() {
		Login.login();
		Home.goToLeadsTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Leads']"));
	}
	
	@Test
	public static void TC21_View_Dropdown_List_Content() {
		Login.login();
		Home.goToLeadsTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Leads']"));
		LeadsPage.checkViewListContents();
	}
	
	@Test
	public static void TC22_Go_Button_Functionality() {
		Login.login();
		Home.goToLeadsTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Leads']"));
		LeadsPage.checkViewListContents();
		LeadsPage.selectViewItem("Today's Leads");
		Home.userNavigation();
		Home.logout();
		Login.login();
		Home.goToLeadsTab();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Leads']"));
		LeadsPage.go();
		String expectedItem = "Today's Leads";
		String actualItem = LeadsPage.defaultViewItem();
		Assert.assertEquals(actualItem, expectedItem);
	}
	
	@Test
	public static void TC23_Todays_Leads() {
		Login.login();
		Home.goToLeadsTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Leads']"));
		LeadsPage.checkViewListContents();
		LeadsPage.selectViewItem("Today's Leads");
		String expectedItem = "Today's Leads";
		String actualItem = LeadsPage.defaultViewItem();
		Assert.assertEquals(actualItem, expectedItem);
	}
	
	@Test
	public static void TC24_New_Button_In_Leads() {
		Login.login();
		Home.goToLeadsTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Leads']"));
		LeadsPage.checkViewListContents();
		LeadsPage.selectViewItem("Today's Leads");
		LeadsPage.newLead();
		NewLeads.enterNewLead("ABCD", "ABCD");
		waitUntilLocatedBy(By.xpath("//input[@id='publishersharebutton'][@title='Share']"));
	}
}
