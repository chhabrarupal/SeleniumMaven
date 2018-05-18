package org.SeleniumMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGmailLogin {
	private WebDriver driver;
  @Test
  public void LoginGmail() {
	  GmailLoginPageObject.email.sendKeys("rupalchhabra0710@gmail.com");
	  //GmailLoginPageObject.forgot_email.click();
	 
	  //GmailLoginPageObject.phone.sendKeys("rupalchhabra0710@gmail.com");
	  GmailLoginPageObject.next.click();
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	  GmailLoginPageObject.password.sendKeys("Pass123");
	  GmailLoginPageObject.next.click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		PageFactory.initElements(driver, GmailLoginPageObject.class);
  }

  @AfterTest
  public void afterTest() {
  }

}
