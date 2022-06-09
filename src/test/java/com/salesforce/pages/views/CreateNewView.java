package com.salesforce.pages.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class CreateNewView extends BaseTest{
	
	protected static WebElement viewNameFld = driver.findElement(By.xpath("//input[@id='fname']"));
	protected static WebElement vUniqueNameFld = driver.findElement(By.xpath("//input[@id='devname']"));
	protected static WebElement saveBtn = driver.findElement(By.xpath("//input[@class='btn primary'][@title='Save']"));
	protected static WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errorMsg']"));
	protected static WebElement cancelBtn = driver.findElement(By.xpath("//input[@class='btn'][@title='Cancel']"));
	
	public static void enterViewName(String viewName) {
		enterText(viewNameFld, viewName);
	}
	
	public static void enterUniqueViewName(String uniqueViewName) {
		enterText(vUniqueNameFld, uniqueViewName);
	}
	
	public static void saveView() {
		clickButton(saveBtn);
	}
	
	public static void cancelView() {
		clickButton(cancelBtn);
	}
	
	public static void enterNewView(String vName, String vUniqueName, boolean saveOrCancel) {
		enterViewName(vName);
		enterUniqueViewName(vUniqueName);
		if(saveOrCancel) {
			saveView();
		}else {
			cancelView();
		}
	}
	
	public static String newViewErrorMsg() {
		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errorMsg']"));
		System.out.println(errorMsg.getText());
		return errorMsg.getText();
	}

}
