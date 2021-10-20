package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C05_NegativeTestConfiguration extends TestBase {

//    https://www.concorthotel.com/ adresine git
//    login butonuna bas
//    test data username: manager1 ,
//    test data password : manager1!
//    Degerleri girildiginde sayfaya girilemedigini test et

    @Test
    public void negativeLoginTest(){
        driver.get(ConfigurationReader.getProperty("CHUrl"));
        ConcortHotelPage chp = new ConcortHotelPage(driver);
        chp.loginButton.click();
        chp.userNameBox.sendKeys(ConfigurationReader.getProperty("CHInvalidUserName"));
        chp.passwordBox.sendKeys(ConfigurationReader.getProperty("CHInvalidPassword"));
        chp.submitButton.click();
        Assert.assertTrue(chp.isLoginFailed.isDisplayed());
    }
}
