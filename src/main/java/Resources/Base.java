package Resources;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class Base {
	
	public static WebDriver driver;
	public static NgWebDriver ngWebDriver;
	public Properties prop = new Properties();
	public WebDriver InitializeDriver() throws IOException {
		
		FileInputStream file = new FileInputStream("/Users/Melissa/eclipse-workspace/PulseNGWebdriver/src/main/java/Resources/data.properties");
		prop.load(file);
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/Melissa/Documents/Selenium-eclipse-files/Drivers/chromedriver");
			driver = new ChromeDriver();
			ngWebDriver = new NgWebDriver((JavascriptExecutor)driver).withRootSelector("[app-run=\"hello.html\"]");
			ngWebDriver.waitForAngularRequestsToFinish();
	        
		}
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/Melissa/Documents/Selenium-eclipse-files/Drivers/geckoriver");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("headlesschrome"))
		{
			System.setProperty("webdriver.driver.chrome", "/Users/Melissa/Documents/Selenium-eclipse-files/Drivers/chromedriver");
			ChromeOptions chromeOptions = new ChromeOptions();
		    chromeOptions.addArguments("--headless");
		    driver = new ChromeDriver(chromeOptions);
		    ngWebDriver = new NgWebDriver((JavascriptExecutor)driver).withRootSelector("[app-run=\"hello.html\"]");
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		else if(browser.contains("phantomjs"))
		{
			File src= new File("/Users/Melissa/Documents/Selenium-Eclipse-Files/Drivers/phantomjs-2.1.1-macosx/bin/phantomjs");
			System.setProperty("phantomjs.binary.path", src.getAbsolutePath());		
			driver = new PhantomJSDriver();
			ngWebDriver = new NgWebDriver((JavascriptExecutor)driver).withRootSelector("[app-run=\"hello.html\"]");
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		else if(browser.contains("htmlunitdriver"))
		{
			driver= new HtmlUnitDriver();
			ngWebDriver = new NgWebDriver((JavascriptExecutor)driver).withRootSelector("[app-run=\"hello.html\"]");
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		//return the driver with all the properties set(kind of driver, implicit wait)
		return driver;
	}
	public void getScreenshot(String result) throws IOException {
		
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/Melissa/Downloads/"+result+"screenshot.png"));
    }

}
