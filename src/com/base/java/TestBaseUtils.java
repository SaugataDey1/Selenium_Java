package com.base.java;

import com.app.pages.HomePage;

public class TestBaseUtils extends Base
{
	public static void pagefactoryinstances()
	{
		homePage = new HomePage(driver);
				
	}

}
