
package com.usermanagement.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StoreData 
{
	
	/* ################################################################################
	 toExcel is used to  store user data to excel based on rowId , ColumnID 
	 ################################################################################*/
	
	public static void toExcel(String fileName, String sheetName,
			 int rowIndex, int celldata, String data)
	{
		try
		{
			File f = new File("./test-data/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.createRow(rowIndex);
			Cell c = r.createCell(celldata);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/* ################################################################################
	 toExcel is overloaded method used to  store user ArrayList data to excel based on rowId , ColumnID 
	 ################################################################################*/
	public static void toExcel(String fileName, String sheetName, ArrayList<ArrayList<String>> data)
	{
		try
		{	
			File f = new File("./test-data/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			for(int i = 0; i < data.size();i++)
			{
				Row r = st.createRow(i);
				for(int j = 0; j < data.get(i).size();j++)
				{
					Cell c = r.createCell(j);
					c.setCellValue(data.get(i).get(j));
				}
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/* ################################################################################
	 writDBdataToExcel method used to  store user ArrayList DB data to excel based on rowId , ColumnID 
	 ################################################################################*/
	public static void writDBdataToExcel (String fileName,String sheetName,ArrayList<ArrayList<String>> data) 
	{
		Workbook wb = new XSSFWorkbook();
        Sheet st = wb.createSheet(sheetName);
		for(int i = 0; i < data.size();i++)
		{
			Row r = st.createRow(i);
			for(int j = 0; j < data.get(i).size();j++)
			{
				Cell c = r.createCell(j);
				c.setCellValue(data.get(i).get(j));
			}
		}
        try 
        {
        	FileOutputStream fos = new FileOutputStream("./test-data/"+fileName+".xlsx");
            wb.write(fos);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	/* ################################################################################
	 toProperties method used to  store data to properties file as key,value 
	 ################################################################################*/
	
	public static void toProperties
	(String fileName, String key, String value, String msg)
	{
		try
		{
			File f = new File("./test-config/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, msg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void toProperties
	(String fileName, String[] keys, String[] values, String msg)
	{
		try
		{
			File f = new File("./test-config/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			for(int i= 0; i < keys.length; i++)
				prop.setProperty(keys[i], values[i]);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, msg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
