package sriram_frmwrk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriram_frmwrk.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
WebDriver driver;

	
	public LandingPage(WebDriver driver) {
		super(driver);
	
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
	
	@FindBy(id="userEmail")
	WebElement userEmail ;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	
	public void login(String email, String pwd) {
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
	}
	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
