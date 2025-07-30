package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FrameworkConstants;

public class ExcelUtils {
	
	private ExcelUtils() {}


	public static Object[] getData(String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath());

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[] data = new Object[rowCount];

		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> map = new HashMap<>();
			
			for (int j = 0; j < colCount; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			data[i - 1] = map;
		}
		workbook.close();
		fis.close();
		return data;
	}

}
