package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Deformatter {
	public String getExcel1(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fs1 = new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		Workbook book = WorkbookFactory.create(fs1);
		Cell cell = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String excelData1 = format.formatCellValue(cell);
		System.out.println(excelData1);
		return excelData1;
	}

}
