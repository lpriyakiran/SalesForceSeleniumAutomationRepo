package com.salesforce.pages.views;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.BaseTest;

public class EditView extends BaseTest{

	protected static WebElement viewNameFld = driver.findElement(By.xpath("//input[@id='fname']"));
	protected static WebElement vUniqueNameFld = driver.findElement(By.xpath("//input[@id='devname']"));
	protected static WebElement saveBtn = driver.findElement(By.xpath("//input[@class='btn primary'][@title='Save']"));
	
	public static void editView() {
		changeViewName("New");
		selectField("Account Name");
		selectOperator("contains");
		enterValue("a");
		selectedFields("Last Activity");
		selectFieldsToDisplay("Last Activity");
		saveView();
	}
	
	public static void changeViewName(String newName) {
		clearElement(viewNameFld);
		enterText(viewNameFld, newName);
	}
	
	public static void selectField(String field) {
		WebElement fieldList = driver.findElement(By.xpath("//select[@id='fcol1']"));
		clickElement(fieldList);		
		Select select = new Select(fieldList);
		select.selectByVisibleText(field);
	}
	
	public static void selectOperator(String oper) {
		WebElement operatorList = driver.findElement(By.xpath("//select[@id='fop1']"));
		clickElement(operatorList);		
		Select select = new Select(operatorList);
		select.selectByVisibleText(oper);
	}
	
	public static void enterValue(String num) {
		WebElement valueField = driver.findElement(By.xpath("//input[@id='fval1']"));
		enterText(valueField, num);
	}
	
	public static void selectFieldsToDisplay(String newField) {
		WebElement availableFields = driver.findElement(By.xpath("//select[@id='colselector_select_0']"));
		Select select = new Select(availableFields);
		select.selectByVisibleText(newField);
		addField();
	}
	
	public static void selectedFields(String newField) {
		WebElement selectedFields = driver.findElement(By.xpath("//select[@id='colselector_select_1']"));
		Select select = new Select(selectedFields);
		List<WebElement> fieldList = driver.findElements(By.xpath("//select[@id='colselector_select_1']/option"));
		for(WebElement field:fieldList) {
			String fieldName = field.getText();
			System.out.println(fieldName);
			if(fieldName.equals(newField)) {
				System.out.println("Removing field before adding again");
				select.selectByVisibleText(newField);
				removeField();
			}else
				System.out.println("Field was not selected previously.");
		}		
	}
	
	public static void addField() {
		WebElement addButton = driver.findElement(By.xpath("//img[@class='rightArrowIcon'][@title = 'Add']"));
		clickButton(addButton);
	}
	
	public static void removeField() {
		WebElement removeButton = driver.findElement(By.xpath("//img[@class='rightArrowIcon'][@title = 'Add']"));
		clickButton(removeButton);
	}
	
	public static void saveView() {
		clickButton(saveBtn);
	}
	
}
