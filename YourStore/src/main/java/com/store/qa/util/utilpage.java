package com.store.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Interface.elemnetsinterface;

public class utilpage implements elemnetsinterface {
	
	public File f1=null;
	public FileInputStream f2=null;
	public XSSFWorkbook b1=null;
	public XSSFSheet s1=null;
	public Row row=null;
	public Cell cell=null;
	
	public void Datapath(String fpath) throws IOException {
		
		f1= new File(fpath);
		f2=new FileInputStream(f1);
		b1= new XSSFWorkbook(f2);
		s1= b1.getSheetAt(0);	
		
	}
	
	public String login(int a, int b)
	{
		row=s1.getRow(a);
		cell=row.getCell(b);
	    String d= cell.getStringCellValue();
	    return d;
	}
	
	public int RowCount(String Sheetname) {
		// TODO Auto-generated method stub
		
	 s1=b1.getSheet(Sheetname);
	 int count=s1.getLastRowNum();
	 return count;
		
	}
	public String getcellDATA(String Sheetname, String Coloumn_name, int rownum)
	{
	    
		int index= b1.getSheetIndex(Sheetname); // checking hgiven sheets index whether its sheet 0 or sheet1 or sheet2 etc
		int colnum = -1;
		s1= b1.getSheetAt(index); //pointing to that sheet
		row=s1.getRow(0);
		int d=row.getLastCellNum();
		
		
		for(int i=0; i<d; i++)
		{
			
			  if (row.getCell(i).getStringCellValue().trim().equals(Coloumn_name.trim())) 
				  colnum=i;
			  
		}
		    row=s1.getRow(rownum-1);
		    cell=row.getCell(colnum);
		    
		    if (cell.getCellType()==CellType.STRING)
		    	
		    { 
		    	String Data =cell.getStringCellValue();
		    	return Data;
		    }
		    else
		    {
		    	String Data1= String.valueOf(cell.getNumericCellValue());
		    	return Data1;
		    }
		    	
		   // return data;
		  
	}
	
	
	public boolean titleValidate(String expectedtitle, String Actualtitle)
	
	
	{ 
		 return expectedtitle.equals(Actualtitle);
		
		}

	public void xpath_click(WebElement xp) {
		// TODO Auto-generated method stub
		xp.click();
	}

	public void xpath_sendk(WebDriver driver,String b ,String d) throws InterruptedException
	
	{
		Thread.sleep(2000);
		WebElement a=driver.findElement(By.xpath(b));
		a.sendKeys(d);
		
	}
	public void mouse_hover(WebDriver driver, WebElement mh) {
		// TODO Auto-generated method stub
		Actions action= new Actions(driver);
		action.moveToElement(mh);
		action.perform();
	
	}

	

}
