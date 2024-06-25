package TestComponents;

import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class locatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// ChromeDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//radio button
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		//Suggession Class Example
		
//		driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("IND");
//		
//		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector(".ui-autocomplete")), "india").build().perform();
//		driver.findElement(By.cssSelector("#ui-id-1:nth-type-of(2)")).click();
		
		/* drop down example */
		
		 Select s=new Select(driver.findElement(By.id("dropdown-class-example")));
		 s.selectByIndex(2);
		 //s.selectByValue("option2");
		 //s.selectByVisibleText("Option2");
		 
		/*check box example*/
		 driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption3")).isSelected());
			 
		/* switch window */
		
		/*driver.findElement(By.id("openwindow")).click();
		System.out.println(driver.getTitle());
		Set<String> tabs = driver.getWindowHandles();
		java.util.Iterator<String> i=tabs.iterator();
		String parentwindow=i.next();
		String childwindow=i.next();
		System.out.println(driver.switchTo().window(childwindow).getTitle());
		//driver.switchTo().window(parentwindow);
		System.out.println(driver.switchTo().window(parentwindow).getTitle());*/
		
		
		/* Switch Tab Example */
		
		/*driver.findElement(By.xpath("//a[contains(@href,'qaclickacademy')]")).click();
		System.out.println(driver.getTitle());
		Set<String> tabs = driver.getWindowHandles();
		java.util.Iterator<String> i=tabs.iterator();
		String parentwindow=i.next();
		String childwindow=i.next();
		System.out.println(driver.switchTo().window(childwindow).getTitle());
		//driver.switchTo().window(parentwindow);
		System.out.println(driver.switchTo().window(parentwindow).getTitle());*/

		 
		 /* Switch To Alert Example */
		String name="shamily";
		driver.findElement(By.id("name")).sendKeys(name);
		Thread.sleep(300);
		//driver.findElement(By.id("alertbtn")).click();
		//driver.switchTo().alert().accept();
		//driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(400);
		driver.switchTo().alert().dismiss();

		//driver.close();
		
	}

}
