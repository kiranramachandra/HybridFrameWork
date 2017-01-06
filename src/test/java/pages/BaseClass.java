package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass 
{
	public WebDriver driver;
	
	public ExtentReports report;
	
	public static ExtentTest logger;
	
	
	@BeforeSuite
	public void setupReport()
	{
		System.out.println("Report started");
		report = new ExtentReports(System.getProperty("user.dir")
				+"/Reports/"+System.currentTimeMillis()+".html");
		
	}
	
	@Parameters("browserName") 
	@BeforeClass
	public void setup(String browser)
	{
		System.out.println("Browser is getting ready");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		System.out.println("Browser and application is ready");
	}
	
	
	@AfterMethod
	public void endTest()
	{
		report.endTest(logger);
		System.out.println("Report for test is generated");
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		System.out.println("Browser and application is down");
	}
	
	
	@AfterSuite
	public void endReport()
	{
		report.flush();
		System.out.println("====Extent report is generated");
	}
	
			

}
