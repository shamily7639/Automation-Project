package seleniumPractice.Carting.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.reusableMethods;

public class CartPage extends reusableMethods {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//List<WebElement> cartitems = driver.findElements(By.cssSelector(".cart"));

	@FindBy(css = ".cart")
	List<WebElement> cartitems;

	@FindBy(css = ".subtotal li button")
	WebElement checkoutele;
	
	//driver.findElement(By.cssSelector(".subtotal li button")).click();

	public boolean verifycartDisplay(String productname) {
		
		 boolean match=cartitems.stream().anyMatch(product->
		 product.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase(productname));
		 return match;
	}
	
	
	public CheckOutPage goToCheckOut() {
		checkoutele.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}
	

}
