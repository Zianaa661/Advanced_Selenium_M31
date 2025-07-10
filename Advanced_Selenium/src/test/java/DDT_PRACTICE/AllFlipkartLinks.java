package DDT_PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class AllFlipkartLinks {
	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("C:\\Users\\Zeenat\\OneDrive\\Desktop\\test1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < links.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));

		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Zeenat\\OneDrive\\Desktop\\test1.xlsx");
		book.write(fos);
		book.close();
		
		int totalrow = sheet.getLastRowNum();
		for (int i = 0; i <= totalrow; i++) {
			Row row = sheet.getRow(i);
			//int totalCells = row.getLastCellNum();
			//for (int j = 0; j < totalCells; j++) {
				Cell cell = row.getCell(0);
				String str = cell.getStringCellValue();
				System.out.println(str);
			}

	}

	}

