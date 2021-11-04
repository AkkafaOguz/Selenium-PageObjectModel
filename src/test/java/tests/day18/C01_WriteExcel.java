package tests.day18;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

//1) Yeni bir Class olusturalim WriteExcel
//2) Yeni bir test method olusturalim writeExcelTest()
//3) Adimlari takip ederek 1.satira kadar gidelim
//4) 4.hucreye yeni bir cell olusturalim
//5) Olusturdugumuz hucreye “Nufus” yazdiralim
//6) 2.satir nufus kolonuna 1500000 yazdiralim
//7) 10.satir nufus kolonuna 250000 yazdiralim
//8) 15.satir nufus kolonuna 54000 yazdiralim
//9) Dosyayi kaydedelim
//10)Dosyayi kapatalim


    @Test
    public void test () throws IOException {

        String filePath = "src/test/java/resources/ulkeler2.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(54000);

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

    }
}
