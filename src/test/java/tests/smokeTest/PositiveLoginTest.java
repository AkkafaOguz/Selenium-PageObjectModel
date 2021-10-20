package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.QaConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTest {

//    Bir test method olustur positiveLoginTest()
//    https://qa-environment.concorthotel.com/ adresine git
//    login butonuna bas
//    test data username: manager ,
//    test data password : Manager1!
//    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void test () {
        Driver.getDriver().get(ConfigurationReader.getProperty("ChQaUrl"));
        QaConcortHotelPage qchp = new QaConcortHotelPage();
        qchp.loginButton.click();
        qchp.userNameBox.sendKeys(ConfigurationReader.getProperty("ChQaValidUserName"));
        qchp.passwordBox.sendKeys(ConfigurationReader.getProperty("ChQaValidPassword"));
        qchp.submitButton.click();

        Assert.assertTrue(qchp.isLoginSuccessfully.isDisplayed());

        Driver.closeDriver();

    }

}
