package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_ConcortHotelLoginNegativeTest extends TestBase {

//    https://www.concorthotel.com/ adresine git
//    login butonuna bas
//    test data username: manager1 ,
//    test data password : manager1!
//    Degerleri girildiginde sayfaya girilemedigini test et

    @Test
    public void negativeLoginTest() {
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage chp = new ConcortHotelPage(driver);
        chp.loginButton.click();
        chp.userNameBox.sendKeys("manager1");
        chp.passwordBox.sendKeys("manager1!");
        chp.submitButton.click();
        Assert.assertTrue(chp.isLoginFailed.isDisplayed());
        driver.quit();

    }
}
