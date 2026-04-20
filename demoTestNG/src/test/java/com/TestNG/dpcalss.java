package com.TestNG;

import org.testng.annotations.DataProvider;


public class dpcalss {

	@DataProvider(name="testData",parallel=true)
	public Object[][] dataSearch()
	{
		return new Object[][] {{"admin1","admin"},{"admin","admin2"}};
	}

}