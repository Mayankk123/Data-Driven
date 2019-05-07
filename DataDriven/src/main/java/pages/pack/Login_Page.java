package pages.pack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.pack.Base_Class;

public class Login_Page extends Base_Class
{
	
	@FindBy(id = "login_field")
	WebElement userId;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='commit']")
	WebElement signin;
	
    public Login_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void gettestdata(String userid,String pasword)
	{
		userId.sendKeys(userid);
		password.sendKeys(pasword);
		signin.click();
	}
}