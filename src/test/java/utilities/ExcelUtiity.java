package utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtiity {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public  ExcelUtiity(String path)
	{

		this.path=path;
	}

	public int getRowCount(String sheetName) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;

	}

	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;

	}

	public String getCellData(String sheetName,int rownum,int column) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);

		DataFormatter formatter =new DataFormatter();
		String data;
		try {
			data= formatter.formatCellValue(cell); //Returns the formated value of a cell as string regardless of 
		}
		catch(Exception e)
		{

			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}

	public void setCellData(String sheetName,int rownum,int column, String data) throws IOException

	{
		File xlfile = new File(path);
		if (!xlfile.exists())    // if file does not exists then Create new File
		{
			workbook=new XSSFWorkbook();	
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}

		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);

		if(workbook.getSheetIndex(sheetName)==-1) //if sheet not exists then create new sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);

		if(sheet.getRow(rownum)==null)  //if row not exists then create new Row
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);

		cell=row.createCell(column);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();


	}

	public void fillGreenColor(String sheetName,int rownum,int column) throws IOException

	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);

		sheet=workbook.getSheet(sheetName);

		row=sheet.getRow(rownum);

		cell=row.getCell(column);

		style=workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	public void fillRedColor(String sheetName,int rownum,int column) throws IOException

	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);

		sheet=workbook.getSheet(sheetName);

		row=sheet.getRow(rownum);

		cell=row.getCell(column);

		style=workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}





}
