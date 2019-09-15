package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory OR
	
	@FindBy(name="username")
	WebElement username;
	   
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement Loginbtn;
	
//	@FindBy(linkText="Sign Up")
//	WebElement signUp;
//	
//	@FindBy(xpath="")
//	WebElement CrmLogo;
//	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	//Actions:
    public String validateLoginPageTitle() {
      return driver.getTitle();	
    }
    //public boolean validateCrmImg() {
    	//return CrmLogo.isDisplayed();
    //}
    public HomePage Login(String un,String pwd) {
    	username.sendKeys(un);
    	password.sendKeys(pwd); 
    	Loginbtn.click();
    	
    	return new HomePage();
    }
}
