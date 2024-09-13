package sriram_frmwrk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriram_frmwrk.AbstractComponents.AbstractComponent;

public class ConifrmationPage extends AbstractComponent{
WebDriver driver;
	public ConifrmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(className= "hero-primary")
	WebElement confirmationmsg;
	
	public String checkconfirmationmsg() {
		
		System.out.println(confirmationmsg.getText());
		return confirmationmsg.getText();
	}

	
	
	
	
}
