package com.salesforce.pages.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.BaseTest;

public class NewOpportunity extends BaseTest{
	
	public static void enterOptyName(String name) {
		WebElement optyNameFld = driver.findElement(By.id("opp3"));
		enterText(optyNameFld, name);
	}
	
	public static void enterAccName(String name) {
		WebElement accNameFld = driver.findElement(By.id("opp4"));
		enterText(accNameFld, name);
	}
	
	public static void selectLeadSource() {
		WebElement leadSourceDD = driver.findElement(By.id("opp6"));
		Select select = new Select(leadSourceDD);
		select.selectByIndex(1);
	}
	
	public static void enterCloseDate(String date) {
		WebElement closeDateFld = driver.findElement(By.id("opp9"));
		enterText(closeDateFld, date);
	}
	
	public static void selectStage() {
		WebElement stageDD = driver.findElement(By.id("opp11"));
		Select select = new Select(stageDD);
		select.selectByIndex(2);
	}
	
	public static void enterProbability(String num) {
		WebElement probabFld = driver.findElement(By.id("opp12"));
		enterText(probabFld, num);
	}
	
	public static void enterPrimaryCampSource() {
		WebElement primCampFld = driver.findElement(By.id("opp17"));
		enterText(primCampFld, "ABCD");
	}
	
	public static void saveOpty() {
		WebElement saveButton = driver.findElement(By.xpath("//input[@class='btn'][@name='save']"));
		clickButton(saveButton);
	}
	
	public static void createNewOpty() {
		enterOptyName("Sales");
		enterAccName("Ammu2");
		selectLeadSource();
		enterCloseDate("6/30/2022");
		selectStage();
		//enterProbability("50");
		//enterPrimaryCampSource();
		saveOpty();
		waitUntilLocatedBy(By.xpath("//input[@id='publishersharebutton'][@title='Share']"));
	}

}
