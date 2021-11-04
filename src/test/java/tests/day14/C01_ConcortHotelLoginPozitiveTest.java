package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPozitiveTest extends TestBase {

//    1 ) Bir Class olustur : PositiveTest
//    2) Bir test method olustur positiveLoginTest()
//    https://www.concorthotel.com/ adresine git
//    login butonuna bas
//    test data username: manager ,
//    test data password : Manager1!
//    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    @Test
    public void positiveLoginTest() {

        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage chp = new ConcortHotelPage(driver);

        chp.loginButton.click();
        chp.userNameBox.sendKeys("manager");
        chp.passwordBox.sendKeys("Manager1!");
        chp.submitButton.click();
        Assert.assertTrue(chp.isLoginSuccessfully.isDisplayed());
        driver.quit();
    }



}
