package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	
	@FindBy(xpath="//span[contains(text(),'My Account')]") WebElement myaccount;
	@FindBy(xpath="//a[contains(text(),'Register')]") WebElement register;
	
	
	

}
