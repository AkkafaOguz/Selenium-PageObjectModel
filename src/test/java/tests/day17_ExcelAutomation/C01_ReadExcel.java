package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

//. Dosya yolunu bir String degiskene atayalim
//8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
//9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
//10. WorkbookFactory.create(fileInputStream)
//11. Worksheet objesi olusturun workbook.getSheetAt(index)
//12. Row objesi olusturun sheet.getRow(index)
//13. Cell objesi olusturun row.getCell(index)

    @Test
    public void test () throws IOException {

        String filePath = "src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(2);

        Cell cell = row.getCell(3);

        System.out.println(cell);
    }

    @Test
    public void test2 () throws IOException {

        String filePath = "src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Cell cell = workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        //secilen hucredeki yazinin Luanda oldugunu test edin.


    }
}
