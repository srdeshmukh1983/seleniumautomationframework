package sriram_frmwrk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.pageobjects.ConfirmationPage;
import sriram_frmwrk.AbstractComponents.AbstractComponent;

public class checkOutPage extends AbstractComponent {
  WebDriver driver;
	public checkOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
		@FindBy(css=".action__submit")
		WebElement submit;
		@FindBy(css="[placeholder='Select Country']")
		WebElement Country;
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement selectcountry;
		By by=By.cssSelector(".ta-results");
		
		public void selectCountry(String countryname) {
			Actions a = new Actions(driver);
			a.sendKeys(Country, countryname).build().perform();
			WaitforelementToAppear(By.cssSelector(".ta-results"));
			selectcountry.click();
		}
		public void  submitOrder() {
			submit.click();
			
		}
	
	
	

}
