package seleniumPractice.Carting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.reusableMethods;

public class LandingPage extends reusableMethods {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement pwd;

	@FindBy(id = "login")
	WebElement loginbutton;

	public ProductsPage loginApplication(String name, String password) {

		username.sendKeys(name);
		pwd.sendKeys(password);
		loginbutton.click();
		ProductsPage ProductsPage=new ProductsPage(driver);
		return  ProductsPage;

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
