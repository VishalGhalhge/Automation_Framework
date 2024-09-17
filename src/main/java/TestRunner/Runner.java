package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="C:/Users/VIGHALGE/Desktop/Cucumber/Web_App/Features/Login_Feature.feature",
		glue="Stepdefination",
		dryRun=false,
		tags= ("@Test_Id_1"),
		monochrome=false,
		plugin= {"pretty","html:Reports/cucumber-pretty","rerun:Failed/reRunFailed.txt"}
		
		
		)


public class Runner extends AbstractTestNGCucumberTests{

}
