package com.store.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	WebDriver w= new ChromeDriver();
	
	public void main() throws InterruptedException
	{
		w.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
	    Thread.sleep(2000);
		
	}

}
