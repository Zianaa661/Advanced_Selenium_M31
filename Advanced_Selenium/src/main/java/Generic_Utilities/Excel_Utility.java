package Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**This method helps to fetch Excel cell value
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws Throwable
	 */
	
	public String getExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fs1 = new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		Workbook book = WorkbookFactory.create(fs1);
		String excelData = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}
	
	
	
	public String getExcelDataUsingFormatter(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fs1 = new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		Workbook book = WorkbookFactory.create(fs1);
		Cell cell = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		System.out.println(ExcelData);
		return ExcelData;
	}


}
