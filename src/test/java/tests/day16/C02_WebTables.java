package tests.day16;

import org.testng.annotations.Test;
import pages.QaConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.Driver;

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
    public void test() {
        QaConcortHotelPage qa = new QaConcortHotelPage();
        qa.ConcortHotelLogin();
        qa.hotelManagementButton.click();
        qa.hotelRoomsButton.click();


    }
}
