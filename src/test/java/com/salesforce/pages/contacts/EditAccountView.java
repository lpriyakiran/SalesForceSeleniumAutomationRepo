package com.salesforce.pages.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class EditAccountView extends BaseTest{
	
	protected static WebElement viewNameFld = driver.findElement(By.xpath("//input[@id='fname']"));
	protected static WebElement vUniqueNameFld = driver.findElement(By.xpath("//input[@id='devname']"));
	protected static WebElement saveBtn = driver.findElement(By.xpath("//input[@class='btn primary'][@title='Save']"));
	
	public static void changeViewName(String newName) {
		clearElement(viewNameFld);
		enterText(viewNameFld, newName);
	}
	

}
