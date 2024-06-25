package reusableMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumPractice.Carting.pageobjects.CartPage;

public class reusableMethods {
	WebDriver driver;
	WebDriverWait wait;
	
	public reusableMethods(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	public CartPage goToCart() {
		cartheader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public void waitimplicit(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void waitForElementToAppear(By findBy) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		
		 wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
