package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver localDriver ;
	
	public loginPage(WebDriver driver) {
		
		localDriver = driver;
		
		// To initialize the page object
		PageFactory.initElements(driver, this);
	}
	
	// Email web-element
	@FindBy(id ="Email")
	public WebElement email;
	
	// Password web-element
	@FindBy(id ="Password")
	public WebElement password;
	
	// Login-button web-element
	@FindBy(xpath ="//*[text()='Log in']")
	public WebElement login_button;
	
	
	// Log-out button
	@FindBy(linkText="/logout")
	public WebElement logout_button;
	
	
public void enterText(WebElement element, String text ) {
		
		try{
			element.sendKeys(text);
		}catch(Exception e) {
			System.out.println("exception occured in Action class -- for entertext method : " +e );
		}
	}
	
	
	public void click(WebElement element ) {
		
		try{
			element.click();
		}catch(Exception e) {
			System.out.println("exception occured in Action class -- for click method : " + e );
		}
	}
	
	public String getTitle(WebDriver driver ) {
		
		String title = driver.getTitle();
		
		return title;
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
}
