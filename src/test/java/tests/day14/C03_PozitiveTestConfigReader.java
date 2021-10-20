package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C03_PozitiveTestConfigReader extends TestBase {

//    1 ) Bir Class olustur : PositiveTest
//    2) Bir test method olustur positiveLoginTest()
//    https://www.concorthotel.com/ adresine git
//    login butonuna bas
//    test data username: manager ,
//    test data password : Manager1!
//    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    @Test
    public void positiveLoginTest() {

        driver.get(ConfigurationReader.getProperty("CHUrl"));
        ConcortHotelPage chp = new ConcortHotelPage(driver);
        chp.loginButton.click();
        chp.userNameBox.sendKeys(ConfigurationReader.getProperty("CHValidUserName"));
        chp.passwordBox.sendKeys(ConfigurationReader.getProperty("CHValidPassword"));
        chp.submitButton.click();
        Assert.assertTrue(chp.isLoginSuccessfully.isDisplayed());
    }

}
