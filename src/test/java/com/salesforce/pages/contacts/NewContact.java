package com.salesforce.pages.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class NewContact extends BaseTest{
	
	protected static WebElement lastNameFld = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	protected static WebElement accNameFld = driver.findElement(By.xpath("//input[@id='con4']"));
	protected static WebElement saveBtn = driver.findElement(By.xpath("//input[@class='btn'][@name='save']"));
	protected static WebElement saveAndNewBtn = driver.findElement(By.xpath("//input[@class='btn'][@name='save_new']"));
	
	public static void enterLastName(String lname){
		waitUntilClickable(lastNameFld);
		enterText(lastNameFld, lname);
	}
	
	public static void enterAcctName(String accName){
		waitUntilClickable(accNameFld);
		enterText(accNameFld, accName);
	}
	
	public static void saveContact() {
		clickButton(saveBtn);
	}
	
	public static void saveAndNewContact() {
		clickButton(saveAndNewBtn);
	}
	
	public static void addNewContact(String lastName, String accName) {
		enterLastName(lastName);
		enterAcctName(accName);
		saveContact();
		waitUntilLocatedBy(By.xpath("//input[@id='publishersharebutton'][@title='Share']"));
	}
	
	public static void saveAndNewContact(String lastName, String accName) {
		enterLastName(lastName);
		enterAcctName(accName);
		saveAndNewContact();
		waitUntilLocatedBy(By.xpath("//input[@id='publishersharebutton'][@title='Share']"));
	}

}
