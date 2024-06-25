package TestComponents;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import seleniumPractice.Carting.pageobjects.LandingPage;

public class BaseTest {

	WebDriver driver;
	public LandingPage page;

	public WebDriver initializeDriver() throws IOException {
//		FileInputStream fis=new FileInputStream("D:\\Workspace\\Carting\\src\\main\\java\\resourses\\globalproperties.properties");
//		Properties prop=new Properties();
//		prop.load(fis);
//		
//		String browserName = prop.getProperty("browser");
//		System.out.println(browserName);
		// System.out.println(chrome.equalsIgnoreCase("chrome"));

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// ChromeDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	

	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 page = new LandingPage(driver);
		page.goTo();
		return page;
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		//read json to string
		String jsonContent=FileUtils.readFileToString(new File("D:\\Workspace\\Carting\\src\\main\\java\\resourses\\purchaseorder.json"),StandardCharsets.UTF_8);
	//string to hashmap
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>()
		{});
		return data;
	}

}
