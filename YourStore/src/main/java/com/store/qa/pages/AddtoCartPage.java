package com.store.qa.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.store.qa.util.utilpage;
import com.sun.tools.javac.util.Assert;

public class AddtoCartPage {
	
	
	@FindBy(xpath="//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]") WebElement components;
	@FindBy(xpath="//a[contains(text(),'Monitors (2)')]") WebElement monitors;
	@FindBy(xpath="//body/div[@id='product-category']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[3]") WebElement apple_com;
	@FindBy(xpath="//body/div[@id='product-category']/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/button[3]") WebElement samsung_com;
	@FindBy(xpath="//a[contains(text(),'product comparison')]") WebElement productcom;
	@FindBy(xpath="//tbody/tr[1]/td[2]/input[1]") WebElement apple_add_tocart;
	@FindBy(xpath="//h1[contains(text(),'Apple Cinema 30\"')]") WebElement apple_title;
	@FindBy(xpath="//tbody/tr[1]/td[3]/input[1]") WebElement samsung_cart;
	@FindBy(xpath="//button[@id='button-upload222']") WebElement apple_uploadfile;
	@FindBy(xpath="//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]") WebElement uploadfile;
	@FindBy(id="button-upload222") WebElement upload;
	@FindBy(name="option[218]") WebElement radio;
	@FindBy(name="option[223][]") WebElement check;
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[5]/textarea[1]") WebElement textarea;
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[10]/button[1]") WebElement art_to_cart_btn;
	@FindBy(xpath="//body[1]/div[2]/div[1]/a[2]") WebElement shopping_cart;
	//@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]/button[1]") WebElement upload;
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/table[1]/tbody[3]/tr[1]/td[3]/input[1]") WebElement sam_addtocart;
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/div[1]/span[1]/button[2]") WebElement remove_btn;
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]/i[1]") WebElement shipTax;
	@FindBy(name="postcode") WebElement postcode;
	@FindBy(id="button-quote") WebElement quote;
	@FindBy(name="shipping_method") WebElement flatrate;
	@FindBy(id="button-shipping") WebElement shippingcharge;
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/div[3]/div[2]/a[1]") WebElement checkout;
	@FindBy(id="button-payment-address") WebElement payaddress;
	@FindBy(id="button-shipping-address") WebElement shipaddress;
	@FindBy(id="button-shipping-method") WebElement shipmethod;
	@FindBy(name="agree") WebElement agreeterm;
	@FindBy(id="button-payment-method") WebElement paymethod;
	@FindBy(id="button-confirm") WebElement confirmorder;
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]") WebElement con;
	utilpage util;
	
		

   public AddtoCartPage(WebDriver driver) {
	   
	   PageFactory.initElements(driver, this);
	   util= new utilpage();
	   
	   
   }
	
	public boolean montitor_title(WebDriver driver,String expectedtitle) throws InterruptedException {
		
		util.xpath_click(components);
		Thread.sleep(1000);
		util.mouse_hover(driver, monitors);
		Thread.sleep(1000);
		util.xpath_click(monitors);
		Thread.sleep(1000);
		String actualtitle= driver.getTitle();
	//	System.out.print("title is" +actualtitle);
        return util.titleValidate(expectedtitle, actualtitle);
		
	}
	
	
	public void compare_product(WebDriver driver) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		util.xpath_click(apple_com);
		Thread.sleep(1000);
		util.xpath_click(samsung_com);
		Thread.sleep(1000);
		util.xpath_click(productcom);
		Thread.sleep(1000);
		
		util.xpath_click(sam_addtocart);
		Thread.sleep(1000);
		
		util.xpath_click(apple_add_tocart);
		Thread.sleep(3000);
	  
			/*	WebElement elem= driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]/button[1]"));
				String js="arguments[0].style.height='auto';arguments[0].style.visibility='visible'; ";
				((JavascriptExecutor)driver).executeScript(js,elem);
				elem.sendKeys("C:\\Users\\pinky\\OneDrive\\Documents\\CRMS\\zone.txt");
				Thread.sleep(3000);*/
		
		util.xpath_click(radio);
		Thread.sleep(1000);
		util.xpath_click(check);
		Thread.sleep(1000);
		
		Select s=new Select(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/select[1]")));
		s.selectByValue("3");
		Thread.sleep(1000);
		textarea.sendKeys("mynamr");
		Thread.sleep(2000);
		util.xpath_click(upload);
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\pinky\\OneDrive\\Documents\\fileuploadScript.exe");
		Thread.sleep(2000);
		
		
		try{
		    System.out.println("Waiting for Alert");
		    WebDriverWait wait = new WebDriverWait(driver,10);
		    wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		    System.out.println("Alert Displayed");
		    Thread.sleep(2000);
		}
		catch (Exception e){
		    System.out.println("Alert not Displayed");
		}
		
		util.xpath_click(art_to_cart_btn);
	    Thread.sleep(1000);
	    util.xpath_click(shopping_cart);
		

        Thread.sleep(1000);
       // util.xpath_click(shopping_cart);
        
		
	}
	
	
	public void shopping_cart(WebDriver driver) throws InterruptedException
	{
		util.xpath_click(remove_btn);
		Thread.sleep(2000);
		
		util.xpath_click(shipTax);
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 330)");
		Thread.sleep(2000);
		
		Select s1=new Select(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		s1.selectByValue("17");
		Thread.sleep(2000);
		
		Select s=new Select(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/select[1]")));
		s.selectByValue("318");
		Thread.sleep(2000);
		postcode.clear();
		Thread.sleep(1000);
		postcode.sendKeys("3045");
		Thread.sleep(2000);
	    util.xpath_click(quote);
	    Thread.sleep(2000);
	    util.xpath_click(flatrate);
	    Thread.sleep(2000);
	    util.xpath_click(shippingcharge);
	    Thread.sleep(2000);
	    util.xpath_click(checkout);
	    Thread.sleep(1000);
	    util.xpath_click(payaddress);
	    Thread.sleep(2000);
	    util.xpath_click(shipaddress);
	    Thread.sleep(2000);
	    util.xpath_click(shipmethod);
	    Thread.sleep(2000);
	    util.xpath_click(agreeterm);
	    Thread.sleep(2000);
	    util.xpath_click(paymethod);
	    Thread.sleep(2000);
	    util.xpath_click(confirmorder);
	    Thread.sleep(2000);
	    util.xpath_click(con);
	    Thread.sleep(2000);
		
	}
	
	public void check_out(WebDriver driver)
	{
		
	}
	public boolean cameras() {
		return true;
		
	}
	
	
}
