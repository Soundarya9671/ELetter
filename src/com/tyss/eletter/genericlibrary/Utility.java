package com.tyss.eletter.genericlibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility 
{
   public void selectByVisibleText(WebElement ele,String text) 
   {
	   
	   Select sel = new Select(ele);
	   sel.selectByVisibleText(text);
	   
	   
   }
}
