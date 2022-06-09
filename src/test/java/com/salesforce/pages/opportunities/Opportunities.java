package com.salesforce.pages.opportunities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.BaseTest;

public class Opportunities extends BaseTest{
	
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
	
	public static void selectOptyPipeline() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		WebElement pipelineLink = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		clickElement(pipelineLink);
	}
	
	public static void selectStuckOpty() {
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunities']"));
		WebElement stuckLink = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		clickElement(stuckLink);
	}
	
	public static void newOpty() {
		WebElement newButton = driver.findElement(By.xpath("//input[@class='btn'][@name='new']"));
		clickButton(newButton);
		waitUntilLocatedBy(By.xpath("//h1[@class='pageType'][text()='Opportunity Edit']"));
	}
	
	public static void selectInterval() {
		WebElement intervalSelector = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		clickElement(intervalSelector);
		Select select = new Select(intervalSelector);
		select.selectByIndex(3);
	}
	
	public static void selectInclude() {
		WebElement includelSelector = driver.findElement(By.xpath("//select[@id='open']"));
		clickElement(includelSelector);
		Select select = new Select(includelSelector);
		select.selectByIndex(3);
	}
	
	public static void runReport() {
		WebElement runButton = driver.findElement(By.xpath("//input[@class='btn'][@title='Run Report']"));
		clickButton(runButton);
	}
	
	public static void runQrtlySummaryReport() {
		selectInterval();
		selectInclude();
		runReport();
	}
	
	public static String pageHeader() {
		waitUntilLocatedBy(By.xpath("//h1[contains(text(),'Opportunity Report')]"));
		WebElement pageHeaderName = driver.findElement(By.xpath("//h1[contains(text(),'Opportunity Report')]"));
		return pageHeaderName.getText();
	}

}
