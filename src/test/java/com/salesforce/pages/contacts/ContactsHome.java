package com.salesforce.pages.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class ContactsHome extends BaseTest{
	
	protected static WebElement newBtn = driver.findElement(By.xpath("//input[@class='btn'][@name='new']"));
	protected static WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	protected static WebElement dispSelection = driver.findElement(By.xpath("//select[@title='Display Selection']"));
	protected static WebElement viewSelection = driver.findElement(By.xpath("//select[@id='fcf']"));
	protected static WebElement goButton = driver.findElement(By.xpath("//input[@class='btn'][@name='go']"));
	
	public static void newContact() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contacts']"));
		clickButton(newBtn);
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contact Edit']"));
	}
	
	public static void creatNewView() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contacts']"));
		clickElement(createNewView);
		waitUntilLocatedBy(By.xpath("//h2[contains(text(),'Create New View')]"));
	}
	
	public static void recentSelection() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contacts']"));
		clickElement(dispSelection);
	}
	
	public static void selectRecentlyCreated() {
		waitUntilLocatedBy(By.xpath("//option[contains(text(),'Recently Created')]"));
		WebElement recentlyCreated = driver.findElement(By.xpath("//option[contains(text(),'Recently Created')]"));
		clickElement(recentlyCreated);
	}
	
	public static void selectView() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contacts']"));
		clickElement(viewSelection);
	}
	
	public static void selectMyContact() {
		waitUntilLocatedBy(By.xpath("//option[contains(text(),'My Contacts')]"));
		WebElement myContacts = driver.findElement(By.xpath("//option[contains(text(),'My Contacts')]"));
		clickElement(myContacts);
		goButtonClick();
		waitUntilLocatedBy(By.xpath("//input[@class='btn'][@title='Add to Campaign']"));
	}
	
	public static void goButtonClick() {
		clickButton(goButton);
	}
	
	public static void selectContact() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Contacts']"));
		WebElement contactName = driver.findElement(By.xpath("//a[contains(text(),'LM')]"));
		clickElement(contactName);
		waitUntilLocatedBy(By.xpath("//input[@id='publishersharebutton'][@title='Share']"));
	}
}
