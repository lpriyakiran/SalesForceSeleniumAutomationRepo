package com.salesforce.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class UnsavedReport extends BaseTest{
	
	public static void enterDateFld() {
		WebElement dateFld = driver.findElement(By.xpath("//input[@name='dateColumn']"));
		clickElement(dateFld);
		WebElement dateItem = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
		clickElement(dateItem);
	}
	
	public static void enterFromDt() {
		WebElement fromDate = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		clickButton(fromDate);
		waitUntilLocatedBy(By.xpath("//button[contains(text(),'Today')]"));
		WebElement todayBtn = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		clickButton(todayBtn);
	}
	
	public static void enterToDt() {
		WebElement toDate = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		clickButton(toDate);
		waitUntilLocatedBy(By.xpath("//button[contains(text(),'Today')]"));
		WebElement todayBtn = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		clickButton(todayBtn);
	}
	
	public static void saveBtn() {
		WebElement saveBtn = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		clickButton(saveBtn);
	}
	
	public static void generateReport() {
		enterDateFld();
		enterFromDt();
		enterToDt();
		saveBtn();
	}

}
