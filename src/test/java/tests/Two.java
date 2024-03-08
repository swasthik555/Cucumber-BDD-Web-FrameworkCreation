package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class Two extends Base{

	WebDriver driver;
	@Test
	public void two() throws IOException, InterruptedException {
		System.out.println("Two");
		driver = initializeDriver();
		driver.get("https://omayo.blogspot.com/");
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
	
}
