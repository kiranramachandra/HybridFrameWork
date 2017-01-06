package testcases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class FirstDDT 
{
	WebDriver driver;
	
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
		driver.get("https://enterprise-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		System.out.println("Browser and application is ready");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
		
	
	@Test(dataProvider="CRMAppData")
	public void loginDiffUser(String username, String password) throws Exception
	{
		System.out.println("=====Test started=====");
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='welcome']")).click();
		driver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a")).click();
		
		System.out.println("========Test End======");
	}
	
	
	@DataProvider(name="CRMAppData")
	public Object[][] getDataApp() throws Exception
	{
		System.out.println("===Test data is getting ready====");
		
		Object [][] logins=new Object[2][2];
		
			
		logins[0][0]="sysadmin";
		logins[0][1]="sysadmin";
		
		logins[1][0]="Admin";
		logins[1][1]="admin";
		System.out.println("===Test data is ready===");
		
		return logins;	
		
	}

}
