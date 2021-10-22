package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortHotel;
import pages.QaConcortHotelPage;
import utilities.Driver;

import java.sql.SQLOutput;
import java.util.List;

public class Odev {


//● login() metodun oluşturun ve oturum açın.
//            ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
//            ○ Username : manager ○ Password : Manager2!
//            ● table() metodu oluşturun
//○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
//○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
//            ● printRows() metodu oluşturun //tr
//○ table body’sinde bulunan toplam satir(row) sayısını bulun.
//            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
//            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
//            ● printCells() metodu oluşturun //td
//○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
//            ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
//            ● printColumns() metodu oluşturun
//○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
//            ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
//            ○ 5.column daki elementleri konsolda yazdırın.

    @Test
    public void login() throws InterruptedException {
        KoalaResortHotel koala = new KoalaResortHotel();
        koala.koalaLogin();
        Thread.sleep(1000);
    }

    //● table() metodu oluşturun

    @Test(dependsOnMethods = "login")
    public void table() {

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> tableColumnElements = Driver.getDriver().findElements(By.xpath("//table//th"));
        System.out.println("Table column number is: " + tableColumnElements.size());

        System.out.println("-------------------------------------------------------------------------");


        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        tableColumnElements.stream().forEach(t -> System.out.print(t.getText()));
        System.out.println();

        String tableBody = Driver.getDriver().findElement(By.xpath("//tbody")).getText();
        System.out.println(tableBody);

        System.out.println("-------------------------------------------------------------------------");

        //● printRows() metodu oluşturun

    }

    static int counter = 0;

    @Test(dependsOnMethods = "table")
    public void printRows() {

        //table body’sinde bulunan toplam satir(row) sayısını bulun.

        List<WebElement> tableBodyElements = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        System.out.println("Table row number is: " + tableBodyElements.size());

        System.out.println("-------------------------------------------------------------------------");

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        tableBodyElements.stream().forEach(t -> System.out.println(++counter + ". Row: " + t.getText()));
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.

        System.out.println("-------------------------------------------------------------------------");

        System.out.println("4. Row's Elements are : " + tableBodyElements.get(3).getText());

        System.out.println("-------------------------------------------------------------------------");

    }

    //● printCells() metodu oluşturun

    @Test(dependsOnMethods = "printRows")
    public void printCells() {

        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun

        List<WebElement> tableBodyCells = Driver.getDriver().findElements(By.xpath("//tbody//tr//td"));
        System.out.println("Cell number in the table body is: " + tableBodyCells.size());

        System.out.println("-------------------------------------------------------------------------");

        // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        counter = 0;
        tableBodyCells.stream().forEach(t -> System.out.println(++counter + ". Cell: " + t.getText()));

        System.out.println("-------------------------------------------------------------------------");

    }


    //● printColumns() metodu oluşturun

    @Test(dependsOnMethods = "printCells")
    public void printColumns() {

        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.

        int columnNumberInTableBody = Driver.getDriver().findElements(By.xpath("//tbody//tr[1]//td")).size();
        System.out.println("Column number in table body is: " + columnNumberInTableBody);

        System.out.println("-------------------------------------------------------------------------");

        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.

        for (int i = 1; i < columnNumberInTableBody + 1; i++) {

            List<WebElement> eachColumnElements = Driver.getDriver().findElements(By.xpath("//tbody//td[" + i + "]"));
            System.out.println(i + ". Column's Elemnts are: ");
            System.out.println("---------------------------");
            eachColumnElements.stream().forEach(t -> System.out.println(t.getText()));
            System.out.println();

        }

        System.out.println("-------------------------------------------------------------------------");

        //○ 5.column daki elementleri konsolda yazdırın.

        List<WebElement> fifthColumnElements = Driver.getDriver().findElements(By.xpath("//tbody//td[5]"));
        System.out.println("5. Column's Elemnts are: ");
        fifthColumnElements.stream().forEach(t -> System.out.println(t.getText()));


    }

}







