package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	
//	public static void main(String[] args) throws IOException {
//		excelRead("E:\\\\ework\\\\tutninja\\\\src\\\\main\\\\java\\\\Excel\\\\testdata.xlsx");
//		
//	}


	public static HashMap<String, String> hs = new HashMap<String,String>();
	
	public static HashMap<String, String> excelRead(String path) throws IOException {
		    File f1 = new File(path);
		
			FileInputStream fis = new FileInputStream(f1);
			
			
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet("Sheet1");
				 int rows = sheet.getLastRowNum();
				System.out.println(rows);
				
				for(int i=1;i<=rows;i++) {
					short cellnum = sheet.getRow(i).getLastCellNum();
					System.out.println(cellnum);
					
					for(int j=0;j<cellnum;j++) {
						String val = sheet.getRow(i).getCell(j).getStringCellValue();
						System.out.println(val);
						
						
						switch (j) {
						case 0:
							hs.put("username", val);
							
							break;
						case 1:
							hs.put("password", val);

						default:
							break;
						}
						
					}
				}
				
				
	return hs;
		
		
	}

}
