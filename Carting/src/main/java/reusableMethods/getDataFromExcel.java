package reusableMethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\Documents\\Book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		wb.getNumberOfSheets();
		System.out.println(wb.getSheetName(0));
	}

}
