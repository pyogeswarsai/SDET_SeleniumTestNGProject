package AmazonTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonParentClass {
WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		WebDriverManager.chromedriver().setup();
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--headless");
		driver =  new ChromeDriver(ch);
		driver.get("https://www.amazon.in");
//		System.out.println("Before method");
//		driver =  new ChromeDriver();
//		driver.get("https://www.amazon.in");
//		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		driver.quit();
	}
}
