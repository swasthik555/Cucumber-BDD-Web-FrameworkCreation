package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class One extends Base{

	WebDriver driver;
	@Test
	public void one() throws IOException, InterruptedException {
		System.out.println("One");
		driver = initializeDriver();
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
}
