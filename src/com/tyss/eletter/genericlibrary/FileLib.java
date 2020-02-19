package com.tyss.eletter.genericlibrary;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib 
{
    FileInputStream ip;
	Properties prop = new Properties();
	
	public String getPropertyKey(String key)
	{
		try 
		{
			ip = new FileInputStream("./src/Externaldata/commonData.properties");
			prop.load(ip);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		 return prop.getProperty(key);
		
	} 
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) 
	

	{
		Workbook wb = null;
       try {
    	   
		     ip = new FileInputStream("./src/Externaldata/TestData.xlsx");
		     wb =  WorkbookFactory.create(ip);
		
          }
       catch(Exception e)
         {
    	   e.printStackTrace();
         }
   
       Sheet s = wb.getSheet(sheetName);
       Cell c = s.getRow(rowNum).getCell(cellNum);
       CellType type = c.getCellType() ;
       
       
       if(type.toString().equals("NUMERIC"))
       	{
    	   
    	   int data = (int)c.getNumericCellValue();
    	   
    	   return String.valueOf(data);
    	   
       	}
       else 
       {
    	   String data = c.getStringCellValue();
    	   
    	   return data;
       
      }
	
	}
}
