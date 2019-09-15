package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
        ContactsPage contactspage;
        HomePage homepage;
	    LoginPage loginpage;
	    TestUtil testutil;
	    
	    String sheetName="contacts";
	    public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		 initialization();
		 contactspage=new ContactsPage();
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchToFrame();
		 contactspage= homepage.clickOnContactsLink();
		 }
	
	@Test(priority=1)
	public void verifyContactsLableTest() {
		
		Assert.assertTrue(contactspage.verifyContactsLable()) ;
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestDate(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) {
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContact("Mr.","tom", "peter","facebook");
		contactspage.createNewContact(title,firstname,lastname,company);
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
}

