package com.store.qa.testcases;

import org.testng.annotations.Test;

import com.store.qa.pages.LoginPage;
import com.store.qa.util.utilpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LoginTest {
	
	WebDriver driver;
	LoginPage login;
	utilpage util;

  @BeforeTest
  public void setup() {
	  
	  driver=new ChromeDriver();
	  driver.get("http://tutorialsninja.com/demo/");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  login= new LoginPage(driver);
	  util=new utilpage();
	  
	  
	  
  }
  
  
  
}
