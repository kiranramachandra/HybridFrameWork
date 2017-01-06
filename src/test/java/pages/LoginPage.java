package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="txtUsername") WebElement uname;
	
	@FindBy(name= "txtPassword") WebElement pass;
	
	@FindBy(xpath="//*[@value='LOGIN']") WebElement loginButton;
	
	
	public void typeUserName()
	{
		uname.sendKeys("Admin");
	}
	
	
	public void typePassword()
	{
		pass.sendKeys("admin");
	}
	
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	}


