package org.SeleniumMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemoWebsite {

	private WebDriver driver;

	@Test
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Rupal");
		driver.findElement(By.name("lastName")).sendKeys("Chhabra");
		driver.findElement(By.id("userName")).sendKeys("rupalchhabra0710@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Accenture,Magarpatta");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
		driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("411028");
		driver.findElement(By.cssSelector("input[id=email]")).sendKeys("rupal chhabra");
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys("Pass123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Pass123");
		
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByValue("92");
		driver.findElement(By.cssSelector("input[type=image]")).click();


	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
