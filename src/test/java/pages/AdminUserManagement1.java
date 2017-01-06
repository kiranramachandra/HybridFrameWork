package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class AdminUserManagement1 
{
	WebDriver driver;
	
	public AdminUserManagement1(WebDriver ldriver)
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
	
	
	public void add_User_To_Application(String empName1,String userName,String pass, String cpass)
	{
		adminLink.click();
		verifyAdminPanel();
		addUser.click();
		empName.sendKeys(empName1);
		uname.sendKeys(userName);
		password.sendKeys(pass);
		confirmPassword.sendKeys(cpass);
		save.click();
		System.out.println("User created successfully");
	}
	
	
	public void verifyAdminPanel()
	{
		boolean status=driver.getCurrentUrl().contains("admin");
		Assert.assertTrue(status);
		System.out.println("===Congrats we are on admin page===");
		
	}
	
	
	
}

