package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QaConcortHotelPage;
import utilities.Driver;

import java.util.List;

public class C02_WebTables {

//● login() metodun oluşturun ve oturum açın.
//● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
//○ Username : manager
// ○ Password : Manager1!
//● table() metodu oluşturun
// ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
// ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
//● printRows() metodu oluşturun //tr
// ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
//○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
//○ 4.satirdaki(row) elementleri konsolda yazdırın.

    @Test
    public void login() throws InterruptedException {
        QaConcortHotelPage qa = new QaConcortHotelPage();
        qa.ConcortHotelLogin();
        qa.hotelManagementButton.click();
        qa.hotelRoomsButton.click();
        Thread.sleep(1000);
    }

    static int counter =0;

    @Test (dependsOnMethods = "login")
    public void table() {

        List <WebElement> columnNumber = Driver.getDriver().findElements(By.xpath("//table//th"));
        System.out.println("Column number of the table: "+columnNumber.size());

        System.out.println("------------------------------------------------------------");


        // Eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
        // tum body'i tek bir Webelement olarak locate edebiliriz
        // Bu yaklasim, tabloda HAPPY HOTEL var mi gibi sorular icin ideal bir cozum olur

        List <WebElement> titlesOfTable = Driver.getDriver().findElements(By.xpath("//thead//th"));
        titlesOfTable.stream().forEach(t-> System.out.print(t.getText()+ " "));
        System.out.println();

        WebElement bodyOfTable = Driver.getDriver().findElement(By.xpath("//tbody"));
        System.out.println(bodyOfTable.getText());


        System.out.println("------------------------------------------------------------");

        List <WebElement> rowNumber = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        System.out.println("Row number of the table: "+rowNumber.size());

        System.out.println("------------------------------------------------------------");

        rowNumber.stream().forEach(t-> System.out.println(++counter +". Satir: "+ t.getText()));

        System.out.println("------------------------------------------------------------");

        List <WebElement> forthRowElements = Driver.getDriver().findElements(By.xpath("//tbody//td[4]"));
        forthRowElements.stream().forEach(t-> System.out.println(t.getText()));





    }
}
