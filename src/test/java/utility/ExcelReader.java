package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{

	XSSFWorkbook wb;
	
	public ExcelReader() throws Exception
	{
		System.out.println("==Excel file is loading==");
		
		String location=System.getProperty("user.dir");
		
		System.out.println("The excel sheet AppData.xlsx is located at>>>" +location);
		
		File src=new File(location+"\\TestData\\AppData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		wb=new XSSFWorkbook(fis);
		
		System.out.println("==Excel file is loaded==");
		
	}
	
	
	public String readStringData(String SheetName, int rowIndex, int ColumnIndex)
	{
		String data=wb.getSheet(SheetName).getRow(rowIndex).getCell(ColumnIndex).getStringCellValue();
		
		return data;
	}
	
	
	public int getRows(String SheetName)
	{

		int row= wb.getSheet(SheetName).getPhysicalNumberOfRows();
		
		return row;
	}
	
	

}
