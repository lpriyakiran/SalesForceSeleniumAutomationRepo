package com.salesforce.pages.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class StuckOpportunities extends BaseTest{
	
	public static String pageHeader() {
		waitUntilLocatedBy(By.xpath("//h1[contains(text(),'Stuck Opportunities')]"));
		WebElement pageHeaderName = driver.findElement(By.xpath("//h1[contains(text(),'Stuck Opportunities')]"));
		return pageHeaderName.getText();
	}

}
