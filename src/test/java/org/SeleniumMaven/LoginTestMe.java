package org.SeleniumMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ExcelUtility;

public class LoginTestMe {
	private WebDriver driver;


	@Test(priority=1)
	public void test_me_login() throws Exception{
		ExcelUtility.setExcelPath("Sheet1","C:\\Users\\A06438_P5.Training\\Desktop\\Selenium_Software\\MyTestApp.xlsx");
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys(ExcelUtility.getCellData(1, 1));
		driver.findElement(By.cssSelector("#password")).clear();
		driver.findElement(By.cssSelector("#password")).sendKeys(ExcelUtility.getCellData(1, 2));
		driver.findElement(By.cssSelector("input.btn:nth-child(1)")).click();

	}

	@Test(priority=2)
	public void select_category() throws Exception {

		Thread.sleep(5000);
		WebElement category= driver.findElement(By.xpath("//*[text()='All Categories']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(category).click().build().perform();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Electronics']")));
		
		WebElement electronics = driver.findElement(By.xpath("//*[text()='Electronics']"));
		act.moveToElement(electronics).click().build().perform();
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Head Phone']")));
		
		WebElement headphone = driver.findElement(By.xpath("//*[text()='Head Phone']"));
		act.moveToElement(headphone).click().build().perform();
		
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "Search");
		
		WebElement addtocart= driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a"));
		addtocart.click();
		
		Thread.sleep(1000);
		WebElement cart=driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]"));
		cart.click();
		
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "View Cart");
		
		WebElement checkout = driver.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a"));
		checkout.click();
		
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "Cart Checkout");
		
		WebElement proceed_to_pay=driver.findElement(By.xpath("//*[@value='Proceed to Pay']"));
		proceed_to_pay.click();
		
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Payment Gateway");
		
		/*WebElement bank = driver.findElement(By.xpath("//input[@value='HDFC Bank']"));
		act.moveToElement(bank).click().build().perform();*/
		
		WebElement done=driver.findElement(By.xpath("//a[text()='Continue']"));
		done.click();
		
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
