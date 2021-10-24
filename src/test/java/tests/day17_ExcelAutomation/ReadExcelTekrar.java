package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class ReadExcelTekrar {



    @Test
    public void firstWay() throws IOException {

        String filePath = "C:\\Users\\90534\\OneDrive\\Masaüstü\\MulakatSorular\\com.Batch30POM\\src\\test\\java\\resources\\ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(5);
        Cell cell = row.getCell(3);

        System.out.println(cell);

        Assert.assertTrue(cell.getStringCellValue().equals("Luanda"));
        Assert.assertTrue(cell.toString().equals("Luanda"));

        //Both of them works


    }

//    Yeni bir test method olusturalim readExcel2()
//- 1.satirdaki 2.hucreye gidelim ve yazdiralim
//- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
//- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
//- Satir sayisini bulalim
//- Fiziki olarak kullanilan satir sayisini bulun
//- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    @Test
    public void test2() throws IOException {

        String filePath= "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Cell cell = workbook.getSheet("Sayfa1").getRow(0).getCell(1);
        System.out.println(cell);
        String cellString = cell.toString();
        System.out.println(cellString);

        Cell cell2 = workbook.getSheet("Sayfa1").getRow(1).getCell(3);
        Assert.assertEquals(cell2.toString(), "Kabil", "Test for 'Capital of Afghanistan' is failed!");
        System.out.println(cell2.toString());

        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());  // Sonucu index uzerinden veriyor.
        System.out.println("Kullanilan satir sayisi: " + (workbook.getSheet("Sayfa1").getLastRowNum()+1));

        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // Sonucu kullanilan satir sayisi olarak veriyor

        System.out.println("Kullanilan sutun sayisi: " + workbook.getSheet("Sayfa1").getRow(0).getLastCellNum()); // Sonucu index uzerinden veriyor.

        Map <String,String> countries = new LinkedHashMap<>();

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {

            countries.put(workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString(),
                          " " + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+" " +
                          workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+" " +
                          workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }

        int counter = 0;

        for (Map.Entry<String,String> w: countries.entrySet()) {

            System.out.println(counter++ +". Column: " + w);
        }

    }
}
