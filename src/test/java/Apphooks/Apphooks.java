package Apphooks;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import configurations.Browserreader;
import configurations.Configreader;
import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Apphooks {
	
	public static Properties prop;
	public static Properties browseprop;
	public static WebDriver driver;
	
	
//	@Before(value = "@initial",order=-1)
//	public void scSkip(Scenario sc) {
//		Assume.assumeTrue(false);
//	}
	
	@Before(order = 0)
	public void initializeProps() throws IOException {
		
		prop = Driverfactory.initProps();
		System.out.println(prop.getProperty("excel_path"));
		
		
	}
	
	@Before(order = 1)
	public void browserLaunch() throws IOException {
		browseprop = Browserreader.readBrowser();
		String browser_name = browseprop.getProperty("browser");
		System.out.println(browser_name);
		driver = Driverfactory.bowserLaunch(browser_name);
		
		
	}
	
	@After(order = 0)
	public static void quit() {
		driver.quit();
	}
	
	@After(order = 1)
	public void screenShot(Scenario sc) {
		
		if(sc.isFailed()) {
			String scname = sc.getName();
		byte[] ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(ts, "image/png", scname);
		}
	
		
	}

}
