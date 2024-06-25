package seleniumPractice.Carting.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.reusableMethods;

public class ConfirmationMessagepage extends reusableMethods {

	WebDriver driver;

	public ConfirmationMessagepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//List<WebElement> cartitems = driver.findElements(By.cssSelector(".cart"));

	@FindBy(css = ".hero-primary")
	WebElement confirmationmessageele;

	

	public String verifyConfirmationMessage() {
		
		return confirmationmessageele.getText();
	}
	
	


}
