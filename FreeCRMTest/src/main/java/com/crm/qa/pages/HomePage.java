package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[@class='headertext']")
	WebElement UserNameLable;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks']")
	WebElement tasksLink;
	
	//initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver,this);
		}
		
		//Actions::::
		
    public String VerifyHomePageTitle() {
    	return driver.getTitle();
    }
    public boolean verifyCorrectUserName() {
    	return UserNameLable.isDisplayed();
    }
    public ContactsPage clickOnContactsLink() {
    	contactsLink.click();
    	return new ContactsPage();
    }
    public DealsPage clickOnDealsLink() {
    	dealsLink.click();
    	return new DealsPage();
    }
    public TasksPage clickonTasksLink() {
    	tasksLink.click();
    	return new TasksPage();
    }
    
    public void clickOnNewContactsLink() {
    	Actions action= new Actions(driver);
    	action.moveToElement(contactsLink).build().perform();
    	newcontactsLink.click();
    }
    
}
