package sriram_frmwrk.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sriram_frmwrk.pages.OrderPage;
import sriram_frmwrk.pages.cartPage;



public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;


	public void WaitforelementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
public void waitforelementtodisappear(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
			wait.until(ExpectedConditions.invisibilityOf(ele));
	
}
public cartPage goToCartPage()
{
	cartHeader.click();
	cartPage cartPage = new cartPage(driver);
	return cartPage;
}

public OrderPage goToOrdersPage()
{
	orderHeader.click();
	OrderPage orderPage = new OrderPage(driver);
	return orderPage;
}
}
