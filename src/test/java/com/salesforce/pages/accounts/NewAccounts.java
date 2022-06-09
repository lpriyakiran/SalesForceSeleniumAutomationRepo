package com.salesforce.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class NewAccounts extends BaseTest{
	
	public static void enterAccName(String accName) {
		waitUntilLocatedBy(By.xpath("//h2[contains(text(),'Account Edit')]"));
		WebElement accNameFld = driver.findElement(By.xpath("//input[@id='acc2']"));
		enterText(accNameFld, accName);
	}
	
	public static void saveNewAccount() {
		WebElement saveButton = driver.findElement(By.xpath("//input[@class='btn'][@name='save']"));
		clickButton(saveButton);
	}
	
	
	public static void createNewAccount(String accName) {
		enterAccName(accName);
		saveNewAccount();
	}

}
