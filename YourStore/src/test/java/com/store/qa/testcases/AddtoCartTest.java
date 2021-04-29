package com.store.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.store.qa.pages.AddtoCartPage;
import com.store.qa.pages.LoginPage;
import com.store.qa.util.utilpage;

import junit.framework.Assert;

public class AddtoCartTest {
	
	WebDriver driver;
	LoginPage login;
	utilpage util;
	AddtoCartPage addtocart;

	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		login= new LoginPage(driver);
		addtocart= new 	AddtoCartPage(driver);	
	}
	
  @Test(priority=1)
  public void logintoAccount() throws InterruptedException, IOException {
	  
	  Assert.assertTrue(login.Title_Check(driver, "Returning Customer"));
	  Thread.sleep(1000);
	  Assert.assertTrue(login.log_account(driver, "My Account"));
	  Thread.sleep(1000);
  }
  
  @Test(priority=2)
  
  public void monitor_check() throws InterruptedException, IOException {
	  
	  Assert.assertTrue(addtocart.montitor_title(driver,"Monitors"));
	  Thread.sleep(1000);
	  addtocart.compare_product(driver);
	  Thread.sleep(1000);
	  addtocart.shopping_cart(driver);
	  
  }
  
  
  
}
