package com.salesforce.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.BaseTest;

public class AccountsHome extends BaseTest{
	
	protected static WebElement newBtn = driver.findElement(By.xpath("//input[@class='btn'][@name='new']"));
	
	public static void clickOnNewAccount() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Accounts']"));
		clickButton(newBtn);
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Account Edit']"));
	}
	
	public static void creatNewView() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Accounts']"));
		WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickElement(createNewView);
		waitUntilLocatedBy(By.xpath("//h2[contains(text(),'Create New View')]"));
	}
	
	public static void selectView() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Accounts']"));
		WebElement viewSelection = driver.findElement(By.xpath("//select[@id='fcf']"));
		
		Select select = new Select(viewSelection);
		select.selectByIndex(1);
	}
	
	public static void editView(){
		WebElement editLink = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
		clickElement(editLink);
		waitUntilLocatedBy(By.xpath("//h2[contains(text(),'Edit View')]"));
	}
	
	public static void mergeAccounts(){
		WebElement mergeLink = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		clickElement(mergeLink);
		waitUntilLocatedBy(By.xpath("//h1[contains(text(),'Merge My Accounts')]"));
	}
	
	public static void accountReport(){
		WebElement accReportLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		clickElement(accReportLink);
		waitUntilLocatedBy(By.xpath("//h2[contains(text(),'Unsaved Report')]"));
//		WebElement noThanksBtn = driver.findElement(By.xpath("//button[contains(text(),'No Thanks')]"));
//		clickButton(noThanksBtn);
	}

}
