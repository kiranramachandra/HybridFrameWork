package testcases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseClass;
import utility.ExcelReader;


public class FirstDDT1 extends BaseClass
{
	
	@Test(dataProvider="CRMAppData")
	public void loginDiffUser(String username, String password) throws Exception
	{
		System.out.println("=====Test started=====");
		
		driver.get("https://enterprise-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
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
		
		ExcelReader excel=new ExcelReader();
		int row=excel.getRows("Login");
		
		Object [][] logins=new Object[row][2];
		
		for(int i=0;i<row;i++)
		{
			logins[i][0]=excel.readStringData("Login", i, 0);	
			logins[i][1]=excel.readStringData("Login",i,1);
		}
			
		
		System.out.println("===Test data is ready===");
		
		return logins;	
		
	}

}
