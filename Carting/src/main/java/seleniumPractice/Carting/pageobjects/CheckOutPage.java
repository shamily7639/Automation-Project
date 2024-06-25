package seleniumPractice.Carting.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reusableMethods.reusableMethods;

public class CheckOutPage extends reusableMethods {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// List<WebElement> cartitems = driver.findElements(By.cssSelector(".cart"));

	@FindBy(css = ".action__submit")
	WebElement submitele;

	@FindBy(css = "[placeholder*=Country]")
	WebElement countryele;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectcountryele;

	// driver.findElement(By.cssSelector(".subtotal li button")).click();

	By countryvisible = By.cssSelector(".ta-results");

	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(countryele, "india").build().perform();
		waitForElementToAppear(countryvisible);

		selectcountryele.click();

	}
	
	public ConfirmationMessagepage submitOrder() {
		submitele.click();
		ConfirmationMessagepage ConfirmationMessagepage = new ConfirmationMessagepage(driver);
		return ConfirmationMessagepage;
	}

}
