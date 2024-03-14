package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;

	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	@FindBy(id = "Form_submitForm_EmailHomePage")
	public WebElement submitForm;


	public String getTextOfForm_submitForm_EmailHomePage()
	{
		String actual = submitForm.getText();
		
		return actual;
	}
}



// ctrt + A , ctrl + i