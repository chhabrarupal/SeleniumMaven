package org.SeleniumMaven;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
	  @Test
	  public void test1() {
		  System.out.println("In test method");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("before test method");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("after test method");
	  }

	}