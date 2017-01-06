package dataProvider;

import utility.ConfigReader;
import utility.ExcelReader;

public class DataProvider 
{
	public static ExcelReader getExcel() 
	{
		ExcelReader reader = null;
		try 
		{
			reader = new ExcelReader();
		} 
		catch (Exception e) 
		{
			
		}
		
		return reader;
		
	}
	
	public static ConfigReader getConfig()
	{
		ConfigReader reader= new ConfigReader();
		
		return reader;
	}

}
