package testcases.hybridTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AdminUserManagement1;
import pages.BaseClass;
import pages.LoginPage1;
import pages.LogoutPage;


public class addUser1 extends BaseClass
{
	@Test
	public void addUserToApplication() throws Exception 
	{
		driver.get("https://enterprise-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		LoginPage1 login=PageFactory.initElements(driver, LoginPage1.class);
		
		login.login_To_Application_As_Admin("Admin","admin");		
		
		AdminUserManagement1 admin=PageFactory.initElements(driver, AdminUserManagement1.class);
		admin.add_User_To_Application("Alice Duval","SeleniumWb", "mukesh","mukesh");
		
		
		LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
		logout.logout_From_Application();
		
	}
	
	
}
