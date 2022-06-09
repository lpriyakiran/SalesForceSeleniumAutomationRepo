package com.salesforce.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;
import com.salesforce.pages.opportunities.NewOpportunity;
import com.salesforce.pages.opportunities.Opportunities;
import com.salesforce.pages.opportunities.OpportunityPipeline;
import com.salesforce.pages.opportunities.StuckOpportunities;

public class Opportunity extends BaseTest{
	
	@Test
	public static void TC15_View_Dropdown_List_Contents() {
		Login.login();
		Home.goToOpportunitiesTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		Opportunities.checkViewListContents();
	}
	
	@Test
	public static void TC16_Create_New_Opty() {
		Login.login();
		Home.goToOpportunitiesTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		Opportunities.newOpty();
		NewOpportunity.createNewOpty();
	}
	
	@Test
	public static void TC17_Opty_Pipeline() {
		Login.login();
		Home.goToOpportunitiesTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		Opportunities.selectOptyPipeline();
		String actualHeader = OpportunityPipeline.pageHeader();
		String expectedHeader = "Opportunity Pipeline";
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test
	public static void TC18_Stuck_Opty() {
		Login.login();
		Home.goToOpportunitiesTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		Opportunities.selectStuckOpty();
		String actualHeader = StuckOpportunities.pageHeader();
		String expectedHeader = "Stuck Opportunities";
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test
	public static void TC19_Quarterly_Summary_Report() {
		Login.login();
		Home.goToOpportunitiesTab();
		Home.closeDialog();
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		Opportunities.runQrtlySummaryReport();
		String actualHeader = Opportunities.pageHeader();
		String expectedHeader = "Opportunity Report";
		Assert.assertEquals(actualHeader, expectedHeader);
	}

}
