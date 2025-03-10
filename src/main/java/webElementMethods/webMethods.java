package webElementMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static stepDefination.UISteps.*;


public class webMethods {
		
	 	public static String pageTitle;
	    public static Actions action ;
	    public static String mainWindow; 
	    public static Set<String> windows;
	    public static Select s;
	    public static String elementText;
	    public JavascriptExecutor js;

	
	
	 
	public static void browserLaunch(String url){
        driver.get(url);
        driver.manage().window().maximize();
        
//        driver.navigate().to(url);
//        driver.navigate().forward();
//        driver.navigate().back();
        


    }
    public static String  getTitle(){
        pageTitle =driver.getTitle();
        return pageTitle;
    }

    public static void implicitWaitSeconds(int time){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void waitForTextToLoad(int time, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+text+"']")));

    }

    public static void waitForElementToLoad(int time, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

    public static void tap(String input){
        
        if( (!input.contains("//"))){
            // With text
            WebElement elementWithText = driver.findElement(By.xpath("//*[text()='"+input+"']"));
            elementWithText.click();
        }else if( input.contains("//")){
            // With Xpath
            WebElement elementWithXpath = driver.findElement(By.xpath(input));
            elementWithXpath.click();
        }else if( input.contains("@id")){
            // With id
            WebElement elementWithId = driver.findElement(By.id(input));
            elementWithId.click();
        }


    }

    public static void sendKeys(String input, String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys( input);
    }

    public static void switchToChildWindow( String title){
    	 mainWindow = driver.getWindowHandle();
        getTitle();
        windows = driver.getWindowHandles();
        for(String window:windows){
            if(!mainWindow.equals(window)){
                driver.switchTo().window(window);
            }
        }
    }

    public static void switchToParentWindow( String title){
    	 mainWindow = driver.getWindowHandle();
        windows = driver.getWindowHandles();
        for(String window:windows){
            if(window.equals(mainWindow)){
                driver.switchTo().window(mainWindow);
                driver.close();
            }
        }
    }

    public static boolean checkPageTitle(String expectedTitle){

        if(expectedTitle.equals(pageTitle)){
            return true;
        }

        return false;
    }

    public static void handleDropdownWithText(String xpath, String text ){
        WebElement element = driver.findElement(By.xpath(xpath));
         s = new Select(element);
         s.selectByValue(text);

    }

    public static void handleDropdownWithIndex(int index ,String xpath ){
        WebElement element = driver.findElement(By.xpath(xpath));
        s = new Select(element);
        s.selectByIndex(index);

    }

    public String getText(String input){

        if( (!input.contains("//"))){
            // With text
            WebElement elementWithText = driver.findElement(By.xpath("//*[text()='"+input+"']"));
            elementText= elementWithText.getText();
        }else if( input.contains("//")){
            // With Xpath
            WebElement elementWithXpath = driver.findElement(By.xpath(input));
            elementText= elementWithXpath.getText();
        }else if( input.contains("@id")){
            // With id
            WebElement elementWithId = driver.findElement(By.id(input));
            elementText =elementWithId.getText();
        }else if( input.contains("@class")){
            // With className
            WebElement elementWithClass = driver.findElement(By.className(input));
            elementText= elementWithClass.getText();
        }

        return elementText;
    }

    public static boolean validateText(String expected){

        if(elementText.equals(expected)){
            return true;
        }
        return false;
    }

    public void swipeDownBy(String input){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ input+");");
    }

    public void swipeUpBy(String input){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ input+");");
    }

    public void scrollToElement(String input){
        WebElement element = driver.findElement(By.xpath(input));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

}
