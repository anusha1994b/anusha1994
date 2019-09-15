package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	//first needs to create a constructor of super class
	public HomePageTest() {
		super();
	}
    @BeforeMethod
     public void setUp() {
	 initialization();
	 loginpage=new LoginPage();
	 testutil=new TestUtil();
	 contactspage=new ContactsPage();
	 homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	 }
     
     @Test(priority=1)
     public void verifyHomePageTitleTest() {
    	 String homePageTitle=homepage.VerifyHomePageTitle();
    	 Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
     }
     
     @Test(priority=3)
     public void verifyUserNameTest() {
    	 testutil.switchToFrame();
    	 Assert.assertTrue(homepage.verifyCorrectUserName());
     }
     @Test(priority=2)
     public void verifyContactsLinkTest() {
    	 testutil.switchToFrame();
    	 contactspage=homepage.clickOnContactsLink();
    	 
     }


    @AfterMethod
	public void teardown() {
		driver.quit();
	}

}