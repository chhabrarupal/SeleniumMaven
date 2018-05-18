package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class TestGmail {
	private WebDriver driver;
  @Test
  public void login() {
	  LoginPageObject.signon.click();
	  LoginPageObject.uname.sendKeys("rupal chhabra");
	  LoginPageObject.password.sendKeys("Pass123");
	  LoginPageObject.submit.click();
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		PageFactory.initElements(driver, LoginPageObject.class);


  }

  @AfterTest
  public void afterTest() {
  }

}
