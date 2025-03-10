package stepDefination;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webElementMethods.webMethods;


import static utilities.readProperties.chromeDriverPath;
import static utilities.readProperties.chromeDriverType;
import static utilities.readProperties.edgeDriverPath;
import static utilities.readProperties.edgeDriverType;
import static utilities.readProperties.firefoxDriverPath;
import static utilities.readProperties.firefoxDriverType;
import static utilities.readProperties.safariDriverPath;
import static utilities.readProperties.safariDriverType;
import static utilities.screenshot.screenshotWithByte;
import static utilities.writeProperties.*;


import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.Assertion;


public class UISteps extends webMethods{
	public static WebDriver driver;
	public static String scenarioId;
    public Assertion assertion ;
    public static String featureFileName;



    @Before
    public void beforeScenario(Scenario scenario){
        // The URI of the feature file is available from the Scenario
        String featureUri = scenario.getUri().toString();
        // Extracting feature name from the URI (feature file name)
        String featureName = featureUri.substring(featureUri.lastIndexOf("/") + 1, featureUri.indexOf(".feature"));
        featureFileName =scenario.getName();
//        report = new extendReport();
//        report.createReport(scenario.getId(),scenario.getName());
        
       

    }

    @BeforeStep
    public void beforeStep(Scenario scenario) throws IOException {
        // Capture the step start in ExtentReport


    }
    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
       scenarioId =scenario.getId();
      
       if(scenario.isFailed()) {
    	   scenario.attach(screenshotWithByte(), "image/png", scenario.getName());
       }
        	
        	
        
    }
    
    @After
    public void afterScenario(Scenario scenario){

        driver.quit();
    }
    @Given("user launch {string} browser with {string} url")
    public void user_launch_browser_with_url(String browserName, String url){

       try{

           switch (browserName.toLowerCase()){
               case "chrome":
                   System.setProperty(chromeDriverType(),chromeDriverPath());
                   driver = new ChromeDriver();
                   break;

               case "firefox" :
                   System.setProperty(firefoxDriverType(),firefoxDriverPath());
                   driver = new FirefoxDriver();
                   break;
               case "edge":
                   System.setProperty(edgeDriverType(),edgeDriverPath());
                   driver = new EdgeDriver();
                   break;
               case "safari":
                   System.setProperty(safariDriverType(),safariDriverPath());
                   driver = new SafariDriver();
                   break;
               default:
                   System.setProperty(chromeDriverType(),chromeDriverPath());
                   driver = new ChromeDriver();

           }

         browserLaunch(url);
       }catch(Exception e){
    	   assertion.assertTrue(false, "Error Message: "+ e.getMessage());
           System.out.println("========== An error occurred while launching the browser =========");
       }
    }

    @Given("user waits for page to load for {int}")
    public void user_waits_for_page_to_load(int time) {
        try{
            implicitWaitSeconds(time);
        }catch(Exception e){
        	assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @Given("user waits for {string} text to load for {int}")
    public void user_waits_for_text_to_load_for(String text, int time) {
        try{

            waitForTextToLoad(time, text);
        }catch(Exception e){
        	assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @When("user click on the button {string}")
    public void user_click_on_the_button(String xpath) {
        try{
            tap(xpath);
        }catch(Exception e){
        	assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @Then("user validate page title and should be {string}")
    public void user_validate_page_title_and_should_be(String expectedTitle) {
        try{
            checkPageTitle(expectedTitle);
        }catch(Exception e){
        	assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while validating title of the page =========");
        }
    }

    @Then("user validate text and should be {string}")
    public void user_validate_text_and_should_be(String string) {
        try{

        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @Then("user waits for text to appear {string}")
    public void user_waits_for_text_to_appear(String text) {
        try{
            waitForTextToLoad(10,text);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @And("user switches to the child window with the title {string}")
    public void userSwitchesToTheChildWindowWithTheTitle(String childpageTitle) {
        try{
            switchToChildWindow(childpageTitle);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @And("user switches to the main window with the title {string}")
    public void userSwitchesToTheMainWindowWithTheTitle(String parentPageTitle) {
        try{
            switchToParentWindow(parentPageTitle);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }


    @And("user enter text {string} using xpath {string}")
    public void userEnterTextUsingXpath(String input, String xpath) {
        try{
            sendKeys(input, xpath);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while entering text =========");
        }

    }


    @And("user waits for element to load xpath {string}")
    public void userWaitsForElementToLoadXpath(String xpath) {
        try{
            waitForElementToLoad(15, xpath);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while waiting for the page to load =========");
        }
    }

    @When("user select {string} value from dropdown for xpath {string}")
    public void userSelectValueFromDropdownForXpath(String text, String xpath) {
        try{
            handleDropdownWithText(text, xpath);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while handling dropdown =========");
        }

    }

    @When("user select {int} value from dropdown for xpath {string}")
    public void userSelectValueFromDropdownForXpath(int index, String xpath) {
        try{
            handleDropdownWithIndex(index, xpath);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while handling dropdown =========");
        }
    }

    @And("user copy text from the element of xpath {string}")
    public void userCopyTextFromTheElementOfXpath(String inputXpath) {
        try{

        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while copying text =========");
        }

    }

    @Then("user validate text for element of {string} and should be {string}")
    public void userValidateTextForElementOfAndShouldBe(String arg0, String arg1) {
        try{

        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while validating text =========");
        }
    }

    @And("user scroll down by {string} pixel")
    public void userScrollDownByPixel(String pixel) {

        try{
            swipeDownBy(pixel);
        }catch(Exception e){
            assertion.assertTrue(false, "Error Message: "+ e.getMessage());
            System.out.println("========== An error occurred while scrolling down =========");
        }
    }

}
