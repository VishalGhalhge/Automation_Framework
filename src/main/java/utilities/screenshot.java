package utilities;

import static stepDefination.UISteps.driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static stepDefination.UISteps.*;

public class screenshot {
	public static LocalDateTime ldt = LocalDateTime.now();
    public static DateTimeFormatter screenshotImageName = DateTimeFormatter.ofPattern("HH-mm-ss");
    public static DateTimeFormatter folderName = DateTimeFormatter.ofPattern("dd-MM-yy");
    public static String name = "image";
    public static int count =0;
    public static String screenShotFolderPath  ="Reports/"+scenarioId+"_"+ldt.format(folderName)+"/screenshot";
	
	public static byte [] screenshotWithByte() {
    	final byte [] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    	return screenShot;
    }
}
