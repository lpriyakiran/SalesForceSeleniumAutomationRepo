package com.salesforce.pages.accounts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.BaseTest;

public class MergeAccounts extends BaseTest{
	
	public static void enterAccName(String accName) {
		WebElement searchAccount = driver.findElement(By.xpath("//input[@title='Find Accounts']"));
		enterText(searchAccount, accName);
	}
	
	public static void findAccounts() {
		WebElement findAccButton = driver.findElement(By.xpath("//input[@class='btn'][@name='srchbutton']"));
		clickButton(findAccButton);
	}
	
	public static void nextPage() {
		WebElement nextButton = driver.findElement(By.xpath("//input[@class='btn'][@title='Next']"));
		clickButton(nextButton);
	}
	
	public static void merge() {
		WebElement mergeButton = driver.findElement(By.xpath("//input[@class='btn'][@title='Merge']"));
		clickButton(mergeButton);
	}
	
	public static void searchAccount(){
		enterAccName("Ammu");
		findAccounts();
	}
	
	public static void selectAndMerge() {
		nextPage();
		merge();
		alertOK();
	}
	
	public static void alertOK() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}

}
