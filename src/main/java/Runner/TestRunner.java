package Runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(
	        features = {
	                "src/test/java/Feature/sampleFeature.feature"

	        },
	        glue = {"stepDefination"},
	        plugin={"pretty",                               
//	                "html:target/cucumber-report.html",      
//	                "rerun:target/failed.txt",
	                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	                },
	        monochrome = true,
	        dryRun = false

	)
	@Test
	public class TestRunner extends AbstractTestNGCucumberTests{
	}

