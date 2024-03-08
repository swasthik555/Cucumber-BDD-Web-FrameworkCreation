package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base{

	WebDriver driver;
	
	@Given("Open the Browser")
	public void open_the_browser() throws IOException {
	   
		driver = initializeDriver();
		
	}

	@And("Navigate to the Login page")
	public void navigate_to_the_login_page() {
	    
		driver.get(prop.getProperty("url"));
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginButton().click();
		
		
	}

	@When("User enters a username as {string} and a password as {string} into the fields")
	public void user_enters_a_username_as_and_a_password_as_into_the_fields(String email, String password) {
	    
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		
	}

	@And("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitButton().click();
		
	}

	@Then("Verify the user is able to successfully login")
	public void verify_the_user_is_able_to_successfully_login() {
	   
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editYourAccount().isDisplayed());
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
}
