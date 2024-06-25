package seleniumPractice.Carting.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.reusableMethods;

public class ProductsPage extends reusableMethods{
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");


	
	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByname(String productname) {
		
		WebElement prod = products.stream().filter(product->
		 product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productname) {
		 WebElement prodname = getProductByname(productname);
		 prodname.findElement(addtocart).click();
		 waitForElementToAppear(toastMessage);
		 waitForElementToDisappear(spinner);
	}
	

	
	
	
	


}
