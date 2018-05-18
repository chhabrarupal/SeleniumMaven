package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest {
  @Test(priority=3)
  public void test2() {
	 try {
		 int a ,b=10,c=0;
		 a=b/c;
	 } catch(Exception e)
	 {
		 throw e;
	 }
  }
  @Test(priority=1)
  public void test3() {
	System.out.println("in test 3");
  } 
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test1");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test1");
  }
  
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("before method");
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("after method");
  }
}
