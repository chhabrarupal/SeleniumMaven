package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NewTest2 {
  @Test(dataProvider = "logindata")
  public void f(String uname, String pass) {
	  System.out.println(uname+" "+pass);
  }

  @DataProvider(name="logindata")
  public String[][] dp() {
    return new String[][] {
      new String[] { "user1", "pass1" },
      new String[] { "user2", "pass2" },
      new String[] { "user3", "pass3" },
    };
  }
}
