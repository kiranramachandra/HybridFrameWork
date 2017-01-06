package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage 
{
	WebDriver driver;
	
	public LogoutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="welcome") WebElement adminName;
	
	@FindBy(xpath=".//*[@id='welcome-menu']/ul/li[2]/a") WebElement logoutLink;
	
	
	public void logout_From_Application() throws Exception
	{
		adminName.click();
		Thread.sleep(2000);
		logoutLink.click();
		
	}


	
		
	
}


