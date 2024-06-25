package seleniumPractice.Carting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;



public class AddCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\BStackDemo\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//ChromeDriver driver = new ChromeDriver(options);
		WebDriver driver=new ChromeDriver(options);
		//driver.get("https://www.google.com/");
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("shamily7639@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		 WebElement prod = products.stream().filter(product->
		 product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		 
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		 
		 driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 List<WebElement> cartitems = driver.findElements(By.cssSelector(".cart"));
		 boolean match=cartitems.stream().anyMatch(product->product.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase("ZARA COAT 3"));
		 
		 SoftAssert Assert = new SoftAssert();

		 Assert.assertTrue(match);
		 driver.findElement(By.cssSelector(".subtotal li button")).click();
		 
		 Actions a=new Actions(driver);
		 a.sendKeys(driver.findElement(By.cssSelector("[placeholder*=Country]")), "india").build().perform();
		 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		 
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		 
		
		//System.out.println(s);

	}

}
