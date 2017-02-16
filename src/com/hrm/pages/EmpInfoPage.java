package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hrm.base.HomePage;
public class EmpInfoPage extends HomePage
{
	public EmpInfoPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(id="btnDelete")
	private WebElement btnDelete;
	
	@FindBy(id="dialogDeleteBtn")
	private WebElement dialogDeleteBtn;
	
	public void clickDelete()
	{
		btnDelete.click();
	}
	public void clickOk()
	{
		dialogDeleteBtn.click();
	}
	
	public void clickEmpCheckbox(String name)
	{
		String xp="//a[text()='"+name+"']/../../td[1]/input";
	driver.findElement(By.xpath(xp)).click();
	}
	
	public void verifyEmployeeIsNotPresent(String name)
	{
		String xp="//a[text()='"+name+"']";
		boolean present = verifyElementIsPresentOrNot(xp);
		Assert.assertFalse(present);
		
		
	}
	

}
