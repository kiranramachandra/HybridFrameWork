package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class AdminUserManagement 
{
	WebDriver driver;
	
	public AdminUserManagement(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath=".//*[@id='menu_admin_viewAdminModule']/b") WebElement adminLink;
	
	@FindBy(id="btnAdd") WebElement addUser;

	@FindBy(xpath=".//*[@id='systemUser_employeeName_empName']") WebElement empName;
	
	@FindBy(id="systemUser_userName") WebElement uname;
	
	@FindBy(how=How.XPATH, using=".//*[@id='systemUser_password']") WebElement password;
	
	@FindBy(how=How.ID, using="systemUser_confirmPassword") WebElement confirmPassword;
	
	@FindBy(how= How.ID, using="btnSave") WebElement save;
	
	
	public void clickOnAdminLink()
	{
		adminLink.click();
	}
	
	
	public void verifyAdminPanel()
	{
		boolean status=driver.getCurrentUrl().contains("admin");
		Assert.assertTrue(status);
		System.out.println("===Congrats we are on admin page===");
		
	}
	
	public void clickOnAddUser()
	{
		addUser.click();
	}
	
	public void typeEmpName()
	{
		empName.sendKeys("Alice Duval");
	}
	
	public void typeUserName()
	{
		uname.sendKeys("London123");
	}
	
	
	public void typePassword()
	{
		password.sendKeys("kiran001");
	}
	
	public void typeConfirmPassword()
	{
		
		confirmPassword.sendKeys("kiran001");
	}
	
	public void clickOnSaveButton()
	{
		save.click();
	}
	
}

