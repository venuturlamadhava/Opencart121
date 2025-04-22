package jsPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFReading {

	public static void main(String[] args) throws IOException {
		
		 FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx");
		 
		 XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		 XSSFSheet sheet=workbook.getSheet("Sheet1");
		 
		 int numOfRows=sheet.getLastRowNum();
		 System.out.println(numOfRows);
		 
		 int numOfCols=sheet.getRow(1).getLastCellNum();
		 System.out.println(numOfCols);
		 
		 for(int r=0;r<numOfRows;r++)
		 {
			 XSSFRow currentRow=sheet.getRow(r);
			 
			 if(currentRow !=null)
			 {
			 for(int c=0;c<numOfCols;c++)
			 {
				 if(currentRow.getCell(c)!=null)
				 {
				String Str=currentRow.getCell(c).toString();
				System.out.print(Str+" |");
				 }
				 else
				 {
				System.out.print("NULL |");
				 }
			 }
			 System.out.println();
			 }
		 }
		 
	}

}
