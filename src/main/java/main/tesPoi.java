package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.TPoDetailDao;
import dto.TPoDetailDto;
import entity.TPoDetail;

public class tesPoi {
	private static final String FILE_NAME = "/fileExcel/databarang.xlsx";

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
		// String tex1 = "satu";
		// String tex2 = "satu";
		//
		// int bandigkan = tex1.compareTo(tex2);
		// System.out.println(bandigkan);
		//
		// TPoDetailDao dao = ctx.getBean(TPoDetailDao.class);
		// List<Object[]> obj = dao.findAllDetail("106");
		// for(Object[] o : obj){
		// TPoDetail d = (TPoDetail) o[0];
		// String itemName = (String) o[1];
		// System.out.println(itemName);
		// System.out.println(d.getPoNo());
		// }
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			// Workbook workbook = new XSSFWorkbook(excelFile);
			// Sheet datatypeSheet = workbook.getSheetAt(0);
			// Iterator<Row> iterator = datatypeSheet.iterator();
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet worksheet = workbook.getSheetAt(0);
			//HSSFRow row1 = worksheet.getRow(1);
			Iterator<Row> iterator = worksheet.rowIterator(); 
			while (iterator.hasNext()){
			Row row1 = iterator.next();
			System.out.println ("Row No.: " + row1.getRowNum ());
			
			if (row1.getRowNum() == 0 ){
				continue;
			}
			Cell cellA = row1.getCell((short) 0);
			String a1Val = cellA.getStringCellValue();
			Cell cellB = row1.getCell((short) 1);
			double b1Val = cellB.getNumericCellValue();
//			Cell cellC = row1.getCell((short) 2);
//			int c1Val =(int)cellC.getNumericCellValue();
//			Cell cellD = row1.getCell((short) 3);
//			double d1Val = cellD.getNumericCellValue();
			System.out.println("A1: " + a1Val);
			System.out.println("B1: " + b1Val);
//			System.out.println("C1: " + c1Val);
//			System.out.println("D1: " + d1Val);
			}
			// while (iterator.hasNext()) {
			//
			// Row currentRow = iterator.next();
			// Iterator<Cell> cellIterator = currentRow.iterator();
			//
			// while (cellIterator.hasNext()) {
			//
			// Cell currentCell = cellIterator.next();
			// //getCellTypeEnum shown as deprecated for version 3.15
			// //getCellTypeEnum ill be renamed to getCellType starting from
			// version 4.0
			// if (currentCell.getCellTypeEnum() == CellType.STRING) {
			// System.out.print(currentCell.getStringCellValue() + "--");
			// } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
			// System.out.print(currentCell.getNumericCellValue() + "--");
			// }
			//
			// }
			// System.out.println();

			// }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
