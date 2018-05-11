package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.paulhammant.ngwebdriver.ByAngular;

public class DashboardPOF {
	
	WebDriver driver;
	public DashboardPOF(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By DashboardBtn = ByAngular.cssContainingText(".dropdown-toggle", "Learn");
	By Button1 = ByAngular.cssContainingText(".button","Download AngularJS");
	By Button2 = ByAngular.cssContainingText(".aria-hidden","x");
	By Button3 = ByAngular.buttonText("Click3");
	
	public WebElement DashboardBtn()
	{
		return driver.findElement(DashboardBtn);
	}
	
	public WebElement Button1()
	{
		return driver.findElement(Button1);
	}
	
	public WebElement Button2()
	{
		return driver.findElement(Button2);
	}
	public WebElement Button3()
	{
		return driver.findElement(Button3);
	}
	
}
