package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.TPoDetailDao;
import dto.TPoDetailDto;
import entity.TPoDetail;

public class TesWriteExcel {
	private static final String FILE_NAME = "/tes2.xlsx";

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

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
		Object[][] datatypes = { { "Datatype", "Type", "Size(in bytes)" },
				{ "int", "Primitive", 2 }, { "float", "Primitive", 4 },
				{ "double", "Primitive", 8 }, { "char", "Primitive", 1 },
				{ "String", "Non-Primitive", "No fixed size" } };

		int rowNum = 0;
		System.out.println("Creating excel");

		for (Object[] datatype : datatypes) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (Object field : datatype) {
				Cell cell = row.createCell(colNum++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}
