package testcases.hybridTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AdminUserManagement;
import pages.BaseClass;
import pages.LoginPage;
import pages.LogoutPage;

//This TC will perform login operation and it will generate Extent Report

public class addUserWithReport extends BaseClass
{
	@Test
	public void addUserToApplication() throws Exception 
	{
		BaseClass.logger=report.startTest("Login with valid user and password");
		
		driver.get("https://enterprise-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		logger.log(LogStatus.INFO, "Login section started");
		
		login.typeUserName();
				
		login.typePassword();
				
		login.clickOnLoginButton();
		
		logger.log(LogStatus.INFO, "Login completed");
				
		AdminUserManagement admin=PageFactory.initElements(driver, AdminUserManagement.class);
		
		admin.clickOnAdminLink();
		Thread.sleep(2000);
		
		admin.verifyAdminPanel();
		Thread.sleep(2000);
		
		admin.clickOnAddUser();
		Thread.sleep(2000);
		
		admin.typeEmpName();
		Thread.sleep(2000);
		
		admin.typeUserName();
		Thread.sleep(2000);
		
		admin.typePassword();
		Thread.sleep(2000);
		
		admin.typeConfirmPassword();
		Thread.sleep(2000);
		
		admin.clickOnSaveButton();
		
		logger.log(LogStatus.PASS,"User created successfully");
	}
	
	@Test
	public void searchUSer() throws Exception
	{
		BaseClass.logger=report.startTest("Logout from current session");
		
		LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
		
		logger.log(LogStatus.INFO,"Logout button clicked");
		
		logout.logout_From_Application();
		
		logger.log(LogStatus.PASS, "Logout successfully");
	}
	

}
