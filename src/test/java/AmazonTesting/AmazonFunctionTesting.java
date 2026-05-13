package AmazonTesting;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonFunctionTesting extends AmazonParentClass{
	
	@Test(priority = 1)
	public void emptyLoginValidation() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		System.out.println("Clicked on Account tab for sign-in");
		Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Clicked on continue without giving credentials");
        boolean isErrorDisplaying = driver.findElement(By.xpath
        		("//div[@class='a-alert-content' and contains(text(),' Enter your mobile number or email')]")).isDisplayed();
        if (isErrorDisplaying) {
        	System.out.println("Empty login credentials Error message displayed");
        }
        Assert.assertTrue(isErrorDisplaying, "Mandatory field error not displayed");
	}
	
	@Test(priority = 2)
	public void invalidLoginCredentials() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		System.out.println("Clicked on Account tab for sign-in");
		Thread.sleep(1000);
		System.out.println("Redirected to sign-in tab");
        driver.findElement(By.id("ap_email_login")).sendKeys("yoge@gmail.com");
		System.out.println("Email entered");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("clicked on continue");
        Thread.sleep(1000);
        driver.findElement(By.id("ap_password")).sendKeys("password");
		System.out.println("Password entered");
        Thread.sleep(1000);
        driver.findElement(By.id("signInSubmit")).click();
		System.out.println("Clicked on sign-in");
        Thread.sleep(1000);
        boolean isErrorDisplayed = driver.findElement(
                By.id("auth-error-message-box")
        ).isDisplayed();
        Thread.sleep(1000);
        if(isErrorDisplayed) {
        	System.out.println("Invalid Credentials Error message displayed");
        } else {
        	System.out.println("Successfully loged in");
        }
        Assert.assertTrue(isErrorDisplayed, "Invalid login error message not displayed");
        Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	public void loginFunctionality() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		System.out.println("Clicked on Account tab for sign-in");
		Thread.sleep(1000);
		System.out.println("Redirected to sign-in tab");
        driver.findElement(By.id("ap_email_login")).sendKeys("6303659389");
		System.out.println("Email entered");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("clicked on continue");
        Thread.sleep(1000);
        driver.findElement(By.id("ap_password")).sendKeys("Amazon@1249");
		System.out.println("Password entered");
        Thread.sleep(1000);
        driver.findElement(By.id("signInSubmit")).click();
		System.out.println("Clicked on sign-in");
        Thread.sleep(1000);
        boolean isLoggedIn = driver.findElement(By.xpath
        		("//span[@id = 'nav-link-accountList-nav-line-1']"))
        		.getText().contains("Hello");
        if(isLoggedIn) {
        	System.out.println("Successfully Logged in");
        }
        Assert.assertTrue(isLoggedIn, "Not logged in");
        Thread.sleep(1000);
	}
	
//	@Test(priority = 4)
//	public void productSearchFunctionality() throws InterruptedException {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox' and @role='searchbox']")).sendKeys("iphone 15");
//		System.out.println("Entered product name in search bar");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']")).click();
//		System.out.println("Clicked the search button");
//		Thread.sleep(1000);
//		String pageTitle = driver.getTitle();
//		System.out.println("Taking the page title " + pageTitle);
//		Assert.assertEquals(pageTitle.contains("iphone 15"),
//                true,"Search keyword 'iphone 15' not found in page title");
//
//	}
//	
//	@Test(priority=5)
//	public void addToCartFunctionality() throws InterruptedException {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox' and @role='searchbox']")).sendKeys("iphone 15");
//		System.out.println("Entered product name in search bar");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']")).click();
//		System.out.println("Clicked the search button");
//		Thread.sleep(1000);
//		String main = driver.getWindowHandle();
//		driver.findElement(By.xpath("(//img[@class = 's-image'])[1]")).click();
//		System.out.println("Selected 1st product and redirected to new page");
//		Set<String> child = driver.getWindowHandles();
//		for(String s : child) {
//			if(!s.equals(main)) {
//				driver.switchTo().window(s);
//				System.out.println("Driver switched to new tab / window");
//				driver.findElement(By.xpath("(//input[@id = 'add-to-cart-button'])[2]")).click();
//				System.out.println("Clicked on add to cart button");
//				Thread.sleep(2000);
//				boolean isMsgDisplayed = driver.findElement(By.xpath("//h1[contains(text(), 'Added to cart')]")).isDisplayed();
//				if(isMsgDisplayed) {
//					System.out.println("Added to Cart message displayed");
//				}
//				Assert.assertTrue(isMsgDisplayed, "Add to cart message not displayed");
//			}
//		}
//	}
	
}
