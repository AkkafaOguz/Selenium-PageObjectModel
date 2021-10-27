package Working;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import utilities.ExcelUtil;


import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class WriteExcel {

    @Test
    public void writeExcel() throws IOException {
        String filePath = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");

        Cell cell = workbook.getSheet("Sayfa1").getRow(0).createCell(4);
        cell.setCellValue("Location");
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }

    @Test
    public void excelUtilTest () {
        ExcelUtil excelUtil = new ExcelUtil("src/test/java/resources/ulkeler.xlsx","Sayfa1");
        System.out.println(excelUtil.getNumberOfColumns());
        System.out.println(excelUtil.getCellData(1, 2));
        System.out.println(excelUtil.getNumberOfRows());
        System.out.println(excelUtil.getNumberOfUsedRows());
        System.out.println(Arrays.deepToString(excelUtil.getAllDataAsArray()));
        excelUtil.setCellData(1,4,"25000");
        System.out.println(excelUtil.getElementsAtTheRow(2));
        for (Map.Entry<String,String> w: excelUtil.getDataAsMap().entrySet()) {
            System.out.println(w);
        }
        excelUtil.setCellData(3,5,"Deneme");

    }
}
