package sriram_frmwrk.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriram_frmwrk.AbstractComponents.AbstractComponent;



public class productCatalogue extends AbstractComponent {
WebDriver driver;

	
	public productCatalogue(WebDriver driver) {
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
	
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	@FindBy(css=".mb-3")
	List<WebElement> products ;
	By productBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toast = By.cssSelector("#toast-container");
	public List<WebElement> getProductList() {
		WaitforelementToAppear(productBy);
	return products;
	}
	
	public WebElement getProductByname(String productname) {
		System.out.println(products);
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productname) {
		WebElement prod = getProductByname(productname);
		prod.findElement(addtocart).click();
		WaitforelementToAppear(toast);
		waitforelementtodisappear(spinner);
	}
}
