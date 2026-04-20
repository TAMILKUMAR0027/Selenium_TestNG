package com.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  @Parameters({"val1","val2"})
  public void sum(int v1,int v2) {
	  int finalsum =v1+v2;
		  System.out.println("The final sum is : "+finalsum);
	  
  }
  @Test
  @Parameters({"val1","val2"})
  public void sum2(int v1,int v2) {
	  int finalsu=v1-v2;
	  System.out.println("The final sum is : "+finalsu);
  }
}
