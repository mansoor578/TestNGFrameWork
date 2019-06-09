package FrameWork.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice1 {
	
	// go to the app shoping cart check to see if the continue buttonn is displayed
		// I want to login in the app in 3 different test cas
		// 1. 1 with coorect user and pass
		// 2 with incorrect user and corrcct password
		// 3. with correct user and incorrect pass
		// 4. with incorect user and pass
	WebDriver driver;

	@BeforeMethod
	public void setEnviroment() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@Test (priority = 1)
	public void testTheShoppingCartContinueBtn() {

		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//span[text() = 'Shopping Cart']")).click();
		boolean cartContinue = driver.findElement(By.xpath("//a[text() = 'Continue']")).isDisplayed();
		Assert.assertTrue(cartContinue);
	}

	@Test (priority = 2)

	public void loginWithCorrectUserAndPass() {

		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test001@test.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test001");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "My Account");
	}

	@Test (priority = 3)
	
	public void loginWithIncorrectUserAndCorrectPass() {
		
		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("tttest001@test.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test001");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		boolean warningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed();
		Assert.assertTrue(warningMessage);
	}
	
	@Test (priority = 4)
	public void loginWithCorrectUserAndIncorrectPass() {
		
		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test001@test.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("ttttttest001");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		boolean warningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed();
		Assert.assertTrue(warningMessage);
	}
	
	
	@Test (priority = 4)
public void loginWithIncorectUserAndPass() {
		
		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("tttest001@test.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("tttttest001");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		boolean warningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed();
		Assert.assertTrue(warningMessage);
	}
	
	
	
	@AfterMethod
	public void closeTheEnviroment() {
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////
}
