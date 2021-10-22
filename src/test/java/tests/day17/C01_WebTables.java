package tests.day17;

import org.testng.annotations.Test;
import pages.QaConcortHotelPage;

public class C01_WebTables {

//    1. Bir metod oluşturun : printData(int row, int column);
//    a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu    hücredeki(cell) veriyi yazdırmalıdır.
//            2. Baska bir Test metodu oluşturun: printDataTest();
//    a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
//    b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
//    c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin


    QaConcortHotelPage qa = new QaConcortHotelPage();

    @Test
    public void test () throws InterruptedException {


            qa.ConcortHotelLogin();
            qa.hotelManagementButton.click();
            qa.hotelRoomsButton.click();
            Thread.sleep(1000);
    }

    @Test (dependsOnMethods = "test")
    public void printData () {

        System.out.println(qa.printData(3, 5));

    }

}
