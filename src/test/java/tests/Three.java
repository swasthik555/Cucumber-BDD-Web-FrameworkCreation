package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Three extends Base{
	
	public WebDriver driver;
	
	@Test
	public void three() throws IOException, InterruptedException {
		
		System.out.println("Sanjay has updated the code");
		System.out.println("Sanjay's second update");
		
		System.out.println("Three");
		driver = initializeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		Assert.assertTrue(false);
		
		
	}
	
	@AfterMethod
	public void tearD() {
		driver.quit();
	}

}
