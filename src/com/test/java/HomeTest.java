package com.test.java;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.java.Base;

public class HomeTest extends Base 
{
	String expected = "Saugata Dey";

	@Test
	public void TC_01()
	{
		Assert.assertEquals(homePage.getTextOfForm_submitForm_EmailHomePage(), expected);
	}
}
