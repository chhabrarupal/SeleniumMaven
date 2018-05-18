package org.SeleniumMaven;

import org.testng.annotations.Test;

import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
public class LoginTestMe_MultipleData {
	private WebDriver driver;
	private static int rownum=0;
	private int colnum=2;

	@Test(dataProvider="logindata")
	public void test_me_login(String UserName,String Password) throws Exception {
		try {
			driver.findElement(By.id("userName")).clear();
			driver.findElement(By.id("userName")).sendKeys(UserName);
			driver.findElement(By.cssSelector("#password")).clear();
			driver.findElement(By.cssSelector("#password")).sendKeys(Password);
			driver.findElement(By.cssSelector("input.btn:nth-child(1)")).click();
			
			String title=driver.getTitle();
			Assert.assertEquals(title, "Home");
			ExcelUtility.setExcelCell(rownum, colnum, "Pass");
			Thread.sleep(5000);
			
		}catch (AssertionError e) {
			ExcelUtility.setExcelCell(rownum, colnum, "Fail");
		}finally {
			rownum++;
			driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
		}
	}

	
	
	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception{
		ExcelUtility.setExcelPath("Sheet2","C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\MyTestApp.xlsx");
		String[][] tabledata= ExcelUtility.getexcelTable();
		return tabledata;
	}


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\drivers\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8083/TestMeApp/login.htm");
	}

	@AfterTest
	public void afterTest() {
	}

}
