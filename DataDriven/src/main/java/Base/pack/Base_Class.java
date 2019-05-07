package Base.pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public Base_Class() 
	{
	 try {
		prop = new Properties();
			
	 FileInputStream ip = new FileInputStream("C:\\Users\\Concretio\\eclipse-workspace\\DataDriven"
	 		+ "\\src\\main\\java\\config\\pack\\configuration.properties");
			
	 prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initilization()
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
				{
			      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Concretio\\Desktop\\eclipse\\chromedriver.exe");
			      driver=new ChromeDriver();
				}
		
		   else if(browsername.equals("FF"))
		      {
	             System.setProperty("webdriver.gecko.driver", "C:\\Users\\Concretio\\Desktop\\eclipse\\geckodriver.exe");
	             driver=new FirefoxDriver();
		      }

		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
		 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}	
	

}

