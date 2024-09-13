package sriram_frmwrk.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import sriram_frmwrk.pages.ConifrmationPage;
import sriram_frmwrk.pages.cartPage;
import sriram_frmwrk.pages.checkOutPage;
import sriram_frmwrk.pages.productCatalogue;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
        WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();

		landingPage.loginApplication("sdd@gmail.com", "Test@123");
		productCatalogue productcatalogue = new productCatalogue(driver);
		List<WebElement> productlist = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		cartPage cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkOutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
	checkoutpage.submitOrder();
	ConifrmationPage cofirmationpage = new ConifrmationPage(driver);
		String confirmmsg = cofirmationpage.checkconfirmationmsg();
		System.out.println("the confirmation message is "+confirmmsg);
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}

}
