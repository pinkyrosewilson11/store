package com.store.qa.testcases;

import com.store.qa.pages.RegisterPage;
import com.store.qa.util.utilpage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest {
	
		public WebDriver driver;
		public RegisterPage Register;
		public utilpage util;
		
		@BeforeTest
		public void setup() throws InterruptedException {
			driver= new ChromeDriver();
			driver.get("http://tutorialsninja.com/demo/");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.manage().deleteAllCookies();
			Register= new RegisterPage(driver);
			util=new utilpage();
			
		}
		
			
		/*@Test(priority=1)
		
		public void validateTitle() throws InterruptedException
		
		{
			Assert.assertTrue(Register.titlecheck(driver, "Register Account"));
			 
		}
	*/
	  @Test(dataProvider="reg")
	  
	  public void NEWRegister(String fname,String lname, String em,String th,String pass,String con) throws InterruptedException
	  {
		  
	 String Observedtitle="Register Account";
	   Register.registerElements(driver,Observedtitle, fname, lname, em, th, pass, con);
		  
		  //System.out.print("first name is"+ fname);
		
	  }
	  
	  @DataProvider
	  public Object reg() throws IOException  {
	  ArrayList<Object> reg= new ArrayList<Object>();
	   util.Datapath("C:\\Users\\pinky\\OneDrive\\Documents\\work1.xlsx");
	  int rowcount= util.RowCount("Data");
	  System.out.print("rowcount is " +rowcount);
	  int rownum=2;
	  for(int i=0;i< rowcount;i++)
	  {
		String f=  util.getcellDATA("Data", "firstname",rownum);
		String l= util.getcellDATA("Data", "lastname",rownum);
		String e= util.getcellDATA("Data", "email",rownum);
		String t= util.getcellDATA("Data", "telephone",rownum);
		String p= util.getcellDATA("Data", "pass",rownum);
		String c= util.getcellDATA("Data", "copassword",rownum);
		 rownum++ ;
		Object[]d= { f,l,e,t,p,c};
		reg.add(d);
		
		
	  }
	 
			
		return reg.iterator();
		
		}
		
	  }
	  

