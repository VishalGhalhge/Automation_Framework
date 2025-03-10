package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import static utilities.screenshot.*;
import static stepDefination.UISteps.*;

public class writeProperties {
	
	public static Properties prop = new Properties();
    public static FileOutputStream file;
    
	public static void updateExtenFile() throws IOException {
		
	        try {
	            file = new FileOutputStream("src/main/resources/extend.properties");
	            
	            prop.setProperty("extend.reporter.spark.start", "true");
	            prop.setProperty("extend.reporter.spark.out", screenShotFolderPath+"/Report/"+"SparkReport.html");
	            
	            prop.setProperty("screenshot.dir", screenShotFolderPath);
	            prop.setProperty("screenshot.rel.path", "../screenshot/");
	            prop.setProperty("basefolder.name","Reports/SparkReports");
	            prop.setProperty("basefolder.datetimepattern","d-MMM-YY-HH-mm-ss");
	            
//	            System.out.println("File Updated");
	            prop.store(file, "Folder path updated");
	            
	        } catch (FileNotFoundException e) {
	        	System.out.println("====== Exception caught while updating extend properties file =======");
	            throw new RuntimeException(e);
	        }finally {
	        	file.close();
	        }
	    

	}

}
