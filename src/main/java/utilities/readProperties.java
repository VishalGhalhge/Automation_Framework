package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
	public static Properties prop = new Properties();
    public static FileInputStream input;

    static {
        try {
            input = new FileInputStream("src/main/resources/browserType.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String chromeDriverType() throws IOException {
        prop.load(input);
      return  prop.getProperty("chromeDriver");
    }

    public static String chromeDriverPath() throws IOException {
        prop.load(input);
        return prop.getProperty("chromeDriverPath");
    }


    public static String edgeDriverType() throws IOException {
        prop.load(input);
        return  prop.getProperty("edgeDriver");
    }
    public static String edgeDriverPath() throws IOException {
        prop.load(input);
        return  prop.getProperty("edgeDriverPath");
    }
    public static String firefoxDriverType() throws IOException {
        prop.load(input);
        return  prop.getProperty("firefoxDriver");
    }
    public static String firefoxDriverPath() throws IOException {
        prop.load(input);
        return  prop.getProperty("firefoxDriverPath");
    }
    public static String safariDriverType() throws IOException {
        prop.load(input);
        return  prop.getProperty("safariDriver");
    }
    public static String safariDriverPath() throws IOException {
        prop.load(input);
        return  prop.getProperty("safariDriverPath");
    }
}
