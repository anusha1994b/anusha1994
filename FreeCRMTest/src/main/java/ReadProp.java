import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadProp {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		Properties prop = new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\dell\\Desktop\\anu\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
        prop.load(ip);
        System.out.println(prop.getProperty("browser"));
        String browserName = prop.getProperty("browser");
        
        
        if(browserName.equals("chrome")) {
        	System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Desktop\\anu\\SeleniumSessions\\lib\\ChromeDriver.exe");
   		  driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")) {
        	driver = new FirefoxDriver();
        }
        else if(browserName.equals("safari")) {
        	driver = new SafariDriver();
        }
        else if(browserName.equals("IE")) {
        	driver =new InternetExplorerDriver();
        }
        else {
        	System.out.println("no broser value is given");
        }
        
        driver.get(prop.getProperty("url"));
        driver.findElement(By.className(prop.getProperty("freecrm_logoimage_classname"))).isDisplayed();
        
        driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
        
	}

}
