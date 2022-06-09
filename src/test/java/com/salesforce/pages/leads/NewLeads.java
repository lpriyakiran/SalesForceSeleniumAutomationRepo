package com.salesforce.pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class NewLeads extends BaseTest{
	
	public static void enterLastName(String lName) {
		WebElement lastNameFld = driver.findElement(By.id("name_lastlea2"));
		enterText(lastNameFld, lName);
	}
	
	public static void enterComapanyName(String company) {
		WebElement companyFld = driver.findElement(By.id("lea3"));
		enterText(companyFld, company);
	}
	
	public static void enterNewLead(String lName, String company) {
		enterLastName(lName);
		enterComapanyName(company);
		saveNewLeads();
	}
	
	public static void saveNewLeads() {
		WebElement saveButton = driver.findElement(By.xpath("//input[@class='btn'][@name='save']"));
		clickButton(saveButton);
	}

}
