package Dashboard;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.DashboardPOF;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Resources.Base;

public class DashboardTest extends Base{
	
	private static Logger log=LogManager.getLogger(DashboardTest.class.getName());
	
	@BeforeTest
	public void Init() throws IOException
	{
		driver = InitializeDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("Url open");
	}
	@BeforeMethod
    public void resetBrowser() {
        //driver.get("about:blank");
    }
	@AfterTest
	public void CloseDriver()
	{
		driver.close();
		driver=null;
	}
	
	@Test
	public void Click1() throws InterruptedException
	{
		
		DashboardPOF Dashboard = new DashboardPOF(driver);
		Dashboard.DashboardBtn().click();
		log.info("Dashboard Clicked");
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "AngularJS — Superheroic JavaScript MVW Framework");
		log.info("Title compared");
		
		
		
		
	}
	/*@Test
	public void Click2()
	{
		
		DashboardPOF Dashboard = new DashboardPOF(driver);
		Dashboard.Button1().click();
		log.info("button Clicked");
		driver.switchTo().frame(1);
		log.info("switched to frame");
		Dashboard.Button2().click();
		log.info("clicked on frame button");
		
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "uperheroic JavaScript MVW Framework");
		log.info("Title compared");
	}*/
	
	
	

}
