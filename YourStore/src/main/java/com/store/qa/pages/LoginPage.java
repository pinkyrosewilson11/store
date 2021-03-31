package com.store.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.qa.util.utilpage;

public class LoginPage {
	

	@FindBy(xpath="//span[contains(text(),'My Account')]") WebElement myaccount;
	@FindBy(xpath="//a[contains(text(),'Login')]") WebElement login;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]") WebElement loginbutton;
	@FindBy(xpath="//h2[contains(text(),'Returning Customer')]") WebElement actualtitle;
	utilpage util;
	
	
	public  LoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		util= new utilpage();
	}
	
	public boolean Title_Check(WebDriver driver, String Expectedtitle) throws InterruptedException
	{
		util.xpath_click(myaccount);
	    Thread.sleep(1000);
	    util.mouse_hover(driver, login);
	    Thread.sleep(1000);
		util.xpath_click(login);
	    Thread.sleep(1000);
		String Actualtitle=actualtitle.getText();
	//	System.out.print("Actual text is ="+ Actualtitle+"  ");
		return(util.titleValidate(Expectedtitle, Actualtitle));
		
	}
	
	public boolean log_account (WebDriver driver,String expectedtitle) throws InterruptedException, IOException
	{   
		util.Datapath("C:\\Users\\pinky\\OneDrive\\Documents\\login.xlsx");
		String username= util.login(1, 0);
		String pass=util.login(1, 1);
		email.sendKeys(username);
		Thread.sleep(1000);
		password.sendKeys(pass);
		Thread.sleep(1000);
		util.xpath_click(loginbutton);
		String Actualtitle=driver.getTitle();
		System.out.print("Actual text is ="+ Actualtitle+"  ");
		
		return util.titleValidate(expectedtitle, Actualtitle);
		
	  
	}
	

}
