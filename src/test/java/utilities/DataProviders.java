package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException
	{
		//String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testdata in Eclipse only
		String path = System.getProperty("user.dir") + "/testdata/Opencart_LoginData.xlsx";

		ExcelUtiity xlutil= new ExcelUtiity(path); //creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store string data
	
	for(int i=1;i<=totalrows;i++) // 1 //read the data from xl storing in two dimensional array
	{
		for(int j=0;j<totalcols;j++) // 0 i is rows, j is columns
		{
			logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
		}
	}
	
	return logindata; //returning  two dimensional array
	
	// Dataprovider 2  add in future
	// Dataprovider  3
	
	
	
	}
}
