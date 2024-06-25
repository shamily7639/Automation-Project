package seleniumPractice.Carting;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestComponents.BaseTest;
import reusableMethods.reusableMethods;
import seleniumPractice.Carting.pageobjects.CartPage;
import seleniumPractice.Carting.pageobjects.CheckOutPage;
import seleniumPractice.Carting.pageobjects.ConfirmationMessagepage;
import seleniumPractice.Carting.pageobjects.LandingPage;
import seleniumPractice.Carting.pageobjects.ProductsPage;

public class submitOrderTest extends BaseTest {

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String,String>data) throws IOException {
		//String productname = "ZARA COAT 3";

		

		ProductsPage ProductsPage = page.loginApplication(data.get("email"), data.get("password"));

		List<WebElement> products = ProductsPage.getProductsList();
System.out.println(data.get("product"));
		WebElement prod = ProductsPage.getProductByname(data.get("product"));
		ProductsPage.addProductToCart(data.get("product"));
		CartPage cartpage = ProductsPage.goToCart();

		boolean match = cartpage.verifycartDisplay(data.get("product"));

		SoftAssert Assert = new SoftAssert();

		Assert.assertTrue(match);

		CheckOutPage checkoutpage = cartpage.goToCheckOut();

		checkoutpage.selectCountry();
		ConfirmationMessagepage ConfirmationMessagepage = checkoutpage.submitOrder();

		String message = ConfirmationMessagepage.verifyConfirmationMessage();

		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		

		// System.out.println(s);

	}
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> input = getJsonDataToMap();
		return new Object[][] {{input.get(0)},{input.get(1)}};
	}

}
