
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1 
{
	WebDriver driver;
	
	public LoginPage1(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="txtUsername") WebElement uname;
	
	@FindBy(name= "txtPassword") WebElement pass;
	
	@FindBy(xpath="//*[@value='LOGIN']") WebElement loginButton;
	
	
	
	public void login_To_Application_As_Admin(String username, String password)
	{
		uname.sendKeys(username);
		
		pass.sendKeys(password);
		
		loginButton.click();
		
		System.out.println("Login completed");
	}
	
	
}


