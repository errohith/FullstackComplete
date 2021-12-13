package selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.S0110.S011072_DownloadPDF;

public class Util {
	
	static List<String> winList;
	static Set<String> windows;
	String[][] data;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	FileInputStream fs;
	FileOutputStream fos;
	int lastRowNum,lastColNum;
	
	public static String getDownloadedFileName() {
		
		File file = new File(S011072_DownloadPDF.downloadPath);
		String[] fileList = file.list();
		return fileList[0];
	}
	
	public static String getLastWindow(WebDriver driver) {
		windows=driver.getWindowHandles();
		winList= new ArrayList<String>();
		winList.addAll(windows);
		System.out.println(winList.size());
		return (winList.get(winList.size()-1));
	}
	
	public String[][] readExcel(String fileName, String sheetName,String Browser) {
		
		try {
			if(Browser.equalsIgnoreCase("Chrome")) {
				fs = new FileInputStream(new File(".\\TestData\\Chrome\\"+fileName+".xlsx"));
			} else if(Browser.equalsIgnoreCase("Firefox")) {
				fs = new FileInputStream(new File(".\\TestData\\Firefox\\"+fileName+".xlsx"));
			}
			
			wb = new XSSFWorkbook(fs);
			sheet=wb.getSheet(sheetName);
			lastRowNum = sheet.getLastRowNum();
			lastColNum = sheet.getRow(0).getLastCellNum();
			data = new String[lastRowNum][lastColNum];
			for(int i=1;i<=lastRowNum;i++ ) {
				for(int j=0;j<lastColNum;j++) {
					if(sheet.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
					{
						data[i-1][j]=Double.toString(sheet.getRow(i).getCell(j).getNumericCellValue());	
					}
					else if(sheet.getRow(i).getCell(j).getCellType()==null) {
						data[i-1][j]="";
					}
					else {
						data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					}
				}
			}	
			wb.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void writeExcel(String fileName, String sheetName,String colName,String Browser) {
		
		int colIndex = 0;
		try {
			if(Browser.equalsIgnoreCase("Chrome")) {
				System.out.println(BaseClass.caseID_Chrome);
				fs = new FileInputStream(new File(".\\TestData\\Chrome\\"+fileName+".xlsx"));
				wb = new XSSFWorkbook(fs);
				sheet=wb.getSheet(sheetName);
				int rowNum=1;
				int colNum=sheet.getRow(0).getLastCellNum();
				for(int it=0;it<colNum;it++) {
					if(sheet.getRow(0).getCell(it).getStringCellValue().equalsIgnoreCase(colName)) {
						colIndex=it;
						break;
					}
				}
				for (String caseID : BaseClass.caseID_Chrome) {
					if(sheet.getRow(rowNum)==null) {
						sheet.createRow(rowNum).createCell(colIndex).setCellValue(caseID);
					}else if (sheet.getRow(rowNum).getCell(colIndex)==null) {
						sheet.getRow(rowNum).createCell(colIndex).setCellValue(caseID);
					} else {
						sheet.getRow(rowNum).getCell(colIndex).setCellValue(caseID);
					}
					rowNum++;
				}
			} else if(Browser.equalsIgnoreCase("Firefox")) {
				System.out.println(BaseClass.caseID_Firefox);
				fs = new FileInputStream(new File(".\\TestData\\Firefox\\"+fileName+".xlsx"));
				wb = new XSSFWorkbook(fs);
				sheet=wb.getSheet(sheetName);
				int rowNum=1;
				int colNum=sheet.getRow(0).getLastCellNum();
				for(int it=0;it<colNum;it++) {
					if(sheet.getRow(0).getCell(it).getStringCellValue().equalsIgnoreCase(colName)) {
						colIndex=it;
						break;
					}
				}
				for (String caseID : BaseClass.caseID_Firefox) {
					if(sheet.getRow(rowNum)==null) {
						sheet.createRow(rowNum).createCell(colIndex).setCellValue(caseID);
					}else if (sheet.getRow(rowNum).getCell(colIndex)==null) {
						sheet.getRow(rowNum).createCell(colIndex).setCellValue(caseID);
					} else {
						sheet.getRow(rowNum).getCell(colIndex).setCellValue(caseID);
					}
					rowNum++;
				}
			}
			
			if(Browser.equalsIgnoreCase("Chrome")) {
				fos = new FileOutputStream(new File(".\\TestData\\Chrome\\"+fileName+".xlsx"));
			} else if(Browser.equalsIgnoreCase("Firefox")) {
				fos = new FileOutputStream(new File(".\\TestData\\Firefox\\"+fileName+".xlsx"));
			}
			//fos = new FileOutputStream(new File(".\\TestData\\"+fileName+".xlsx"));
			wb.write(fos);
			fos.close();
			fs.close();
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
