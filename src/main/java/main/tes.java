package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.TPoDetailDao;
import dto.TPoDetailDto;
import entity.TPoDetail;


public class tes {
	private static final String FILE_NAME = "/fileExcel/databarang.xlsx";
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
//		String tex1 = "satu";
//		String tex2 = "satu";
//		
//		int bandigkan = tex1.compareTo(tex2);
//		System.out.println(bandigkan);
//		
//		TPoDetailDao dao = ctx.getBean(TPoDetailDao.class);
//		List<Object[]> obj = dao.findAllDetail("106");
//		for(Object[] o : obj){
//			TPoDetail d = (TPoDetail) o[0];
//			String itemName = (String) o[1];
//			System.out.println(itemName);
//			System.out.println(d.getPoNo());
//		}
		 try {
	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    //getCellTypeEnum shown as deprecated for version 3.15
	                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
	                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                        System.out.print(currentCell.getStringCellValue() + "--");
	                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        System.out.print(currentCell.getNumericCellValue() + "--");
	                    }

	                }
	                System.out.println();

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}
}
