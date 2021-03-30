package com.store.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.store.qa.util.utilpage;

public class RegisterPage {
	
 
	@FindBy(xpath="//span[contains(text(),'My Account')]") WebElement myaccount;
	@FindBy(xpath="//a[contains(text(),'Register')]") WebElement register;
	@FindBy(xpath="//span[contains(text(),'Shopping Cart')]") WebElement cart;
	@FindBy(xpath="//input[@id='input-firstname']") WebElement name;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement Telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement conpassword;
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[2]/input[1]") WebElement news;
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]") WebElement policy;
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]") WebElement continue1;
	@FindBy(xpath="//a[contains(text(),'Continue')]") WebElement continue2;
	@FindBy(xpath="//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]") WebElement logout;
	
	utilpage util;
	
	
	public RegisterPage(WebDriver driver) throws InterruptedException
	{
  Thread.sleep(2000);
	   PageFactory.initElements(driver, this);
	//   System.out.print("*********success page objects are initilized");
	   util= new utilpage();

		
	   
	}
	
	public boolean titlecheck(WebDriver driver,String expectedtitle) throws InterruptedException
	{
	 util.xpath_click(myaccount);
	 Thread.sleep(2000);
	 util.mouse_hover(driver, register);
	 Thread.sleep(1000);
	 util.xpath_click(register);
     String Actualtitle=driver.getTitle();

	 return util.titleValidate(expectedtitle, Actualtitle);
	
	}
	

	
	public void registerElements(WebDriver driver,String Observedtitle,String fname,String lname, String em,String th,String pass,String con) throws InterruptedException{
		
	
	//	util.xpath_click(continue_btn);
		 util.xpath_click(myaccount);
		 Thread.sleep(2000);
		 util.mouse_hover(driver, register);
		 Thread.sleep(1000);
		 util.xpath_click(register);
		 String ActualTitle=driver.getTitle();
		 
		 
   if(ActualTitle.equals(Observedtitle))
		
	{ 
		Thread.sleep(1000);
		name.sendKeys(fname);
		Thread.sleep(1000);
		lastname.sendKeys(lname);
		Thread.sleep(1000);
		email.sendKeys(em);
		Thread.sleep(1000);
		Telephone.sendKeys(pass);
		Thread.sleep(1000);
		password.sendKeys(pass);
		Thread.sleep(1000);
		conpassword.sendKeys(con);
		Thread.sleep(1000);
		util.xpath_click(news);
		Thread.sleep(1000);
	    util.xpath_click(policy);
	    Thread.sleep(1000);
		util.xpath_click(continue1);
		Thread.sleep(2000);
		util.xpath_click(continue2);
		Thread.sleep(2000);
		//util.xpath_click(cart);
		util.xpath_click(logout);
		Thread.sleep(2000);
	 }
		 
	 else
		 
	 {
		 System.out.println("Not at the Register page");
	 }
		
		
	}
	
	
	

}
