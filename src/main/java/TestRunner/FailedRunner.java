package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@Failed/reRunFailed.txt",
		glue="Stepdefination",
		dryRun=false,
		tags= ("@Test_Id_1"),
		monochrome=false,
		plugin= {"pretty","html:Reports/cucumber-pretty","rerun:Failed/reRunFailed.txt"}
		
		
		)

public class FailedRunner  extends AbstractTestNGCucumberTests {

}
