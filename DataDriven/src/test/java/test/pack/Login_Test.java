package test.pack;

import java.io.IOException;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.pack.Base_Class;
import pages.pack.Login_Page;
import util.pack.ExcelReader;

public class Login_Test extends Base_Class {	
	
	String sheetName = "sheet1";
	//private String filePath = "C:\\Users\\Concretio\\eclipse-workspace\\DataDriven\\src\\main\\java\\testdata\\pack\\testdata.xlsx";

	public Login_Test()
	{
		super();
	}
	@BeforeMethod
	public void init()
	{
		initilization();
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][] = ExcelReader.getTestData(sheetName);
		return data;
	}

    @Test(dataProvider = "getTestData")
    public void logintest(String userid,String pasword)
    {
    	Login_Page login = new Login_Page();
    	
    	login.gettestdata(userid, pasword);
    }
    
    @AfterMethod
    public void end()
    {
    	driver.quit();
    }
   
}
