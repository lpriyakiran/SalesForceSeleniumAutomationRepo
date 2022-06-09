package com.salesforce.pages.leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.BaseTest;

public class LeadsPage extends BaseTest{
	
	protected static WebElement viewDropdownList = driver.findElement(By.id("fcf"));
	
	public static void viewDropDown() {
		clickElement(viewDropdownList);
	}
	
	public static void checkViewListContents() {
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='fcf']/option"));
		for(WebElement listItem:list) {
			System.out.println(listItem.getText());
		}
	}
	
	public static void selectViewItem(String item) {
		Select select = new Select(viewDropdownList);
		select.selectByVisibleText(item);
	}
	
	public static void go() {
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn'][@name='go']"));
		waitUntilClickable(goButton);
		clickButton(goButton);
	}
	
	public static void newLead() {
		WebElement newButton = driver.findElement(By.xpath("//input[@class='btn'][@name='new']"));
		clickButton(newButton);
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Lead Edit']"));
	}
	
	public static String defaultViewItem() {
		WebElement defaultSelection = driver.findElement(By.xpath("//option[@selected='selected']"));
		return defaultSelection.getText();
	}
}
