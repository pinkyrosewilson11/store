package com.store.qa.testcases;

import org.testng.annotations.Test;

import com.store.qa.pages.LoginPage;
import com.store.qa.util.utilpage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LoginTest {
	
	WebDriver driver;
	LoginPage login;
	utilpage util;

  @BeforeTest
  public void setup() throws InterruptedException {
	  
	  driver=new ChromeDriver();
	  driver.get("http://tutorialsninja.com/demo");
	  driver.manage().window().maximize();
	  Thread.sleep(1000);
	  driver.manage().deleteAllCookies();
	  login= new LoginPage(driver);
	  util=new utilpage();
	   
	  
  }
  
  @Test
  public void checkTitle() throws InterruptedException
  {
	  Assert.assertTrue(login.Title_Check(driver, "Returning Customer"));
  }
  
  @Test(priority=2)
  public void login_account() throws InterruptedException, IOException
  
  {
	  Assert.assertTrue(login.log_account(driver,"My Account"));
	  Thread.sleep(1000);
  }
  
  
 
  
}
