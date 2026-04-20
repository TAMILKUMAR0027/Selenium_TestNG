package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderclass {
	@DataProvider(name="testData",parallel = true)
	public Object[][]dataprov(){
		return new Object[][] {{"Tamil"},{"Jeeva"},{"Rishwanth"}};
	}
  
}
