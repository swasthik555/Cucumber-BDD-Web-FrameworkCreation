package tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{

	WebDriver driver;
	Logger log;
	
	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedStatus) {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on my Account dropdown");
		landingPage.loginButton().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailField().sendKeys(email);
		log.debug("Email address got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.submitButton().click();
		log.debug("Clicked on Login button");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult;
		
		try{
			
			accountPage.editYourAccount().isDisplayed();
			log.debug("User got logged in");
			actualResult="Success";
		
		}catch(Exception e) {
			log.debug("User didn't log in");
			actualResult="Failure";
		
		}
		
		Assert.assertEquals(actualResult, expectedStatus);
		
			log.info("Login Test got passed");
		
	}
	
	@BeforeMethod
	public void openBrowser() throws IOException {	
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"spacestudio555@gmail.com","8971059266", "Success"}};
		return data;
	}
	
}
