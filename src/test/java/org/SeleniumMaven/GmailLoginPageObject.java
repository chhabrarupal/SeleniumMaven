package org.SeleniumMaven;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPageObject {
	@FindBy(css=".RveJvd.snByac")
	public static WebElement forgot_email;
	
	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	public static WebElement email;
	
	@FindBy(xpath="//span[text()='Next']")
	public static WebElement next;
	
	@FindBy(id="recoveryIdentifierId")
	public static WebElement phone;
	
	@FindBy(name="password")
	public static WebElement password;


}
