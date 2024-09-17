package Stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Action_Operation.Actions;
import PageObject.loginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class stepDefination {
	
	public WebDriver driver;
	public loginPage loginpage;
	public Actions act;
	
	@Given("user launch browser")
	public void user_launch_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    loginpage = new loginPage(driver);
	    driver.manage().window().maximize();
	}

	@Given("user open url {string}")
	public void user_open_url(String url) {
	    try {
			driver.get(url);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Given("user enter email text as {string}")
	public void user_enter_email_text_as(String text) {
	    try {
	    	loginpage.clearText(loginpage.email);
	    	loginpage.enterText(loginpage.email, text);
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
	
	@Given("user enter password text as {string}")
	public void user_enter_password_text_as(String text) {
	    try {
	    	loginpage.clearText(loginpage.password);
	    	loginpage.enterText(loginpage.password, text);
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}

	@Given("user click on login button")
	public void user_click_on_login_button() {
		try {
	    	
			loginpage.click(loginpage.login_button);
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
	
	@Given("user click on logout button")
	public void user_click_on_logout_button() {
		try {
	    	
			loginpage.click(loginpage.logout_button);
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
	
	
	@Then("user verify title of the page {string}")
	public void user_verify_title_of_the_page(String string) {
		try {
	    	
	    	Assert.assertEquals(driver,string);
	    	
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}

	
	@Then("user close the browser")
	public void user_close_the_browser() {
		try {
	    	driver.close();
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
	
//	@AfterAll
//	public void closeWindow(Scenario s ) {
//		
//		driver.close();
//	}
}
