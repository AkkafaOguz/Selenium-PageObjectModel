package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QaConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTest {

//1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
//3  Farkli test Methodunda 3 senaryoyu test et
// - yanlisSifre
// - yanlisKulllanici
// - yanlisSifreKullanici
//test data yanlis username: manager1 , yanlis password : manager1!
//2) https://qa-environment.concorthotel.com/ adresine git
//3) Login butonuna bas
//4) Verilen senaryolar ile giris yapilamadigini test et


    @Test (groups = "birinciGrup")
    public void invalidUserName () {
        Driver.getDriver().get(ConfigurationReader.getProperty("ChQaUrl"));
        QaConcortHotelPage qchp = new QaConcortHotelPage();
        qchp.loginButton.click();
        qchp.userNameBox.sendKeys(ConfigurationReader.getProperty("ChQaInvalidUserName"));
        qchp.passwordBox.sendKeys(ConfigurationReader.getProperty("ChQaValidPassword"));
        qchp.submitButton.click();
        Assert.assertTrue(qchp.isLoginFailed.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void invalidPassword () {
        Driver.getDriver().get(ConfigurationReader.getProperty("ChQaUrl"));
        QaConcortHotelPage qchp = new QaConcortHotelPage();
        qchp.loginButton.click();
        qchp.userNameBox.sendKeys(ConfigurationReader.getProperty("ChQaValidUserName"));
        qchp.passwordBox.sendKeys(ConfigurationReader.getProperty("ChQaInvalidPassword"));
        qchp.submitButton.click();
        Assert.assertTrue(qchp.isLoginFailed.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void invalidUserNameAndPassword () {
        Driver.getDriver().get(ConfigurationReader.getProperty("ChQaUrl"));
        QaConcortHotelPage qchp = new QaConcortHotelPage();
        qchp.loginButton.click();
        qchp.userNameBox.sendKeys(ConfigurationReader.getProperty("ChQaInvalidUserName"));
        qchp.passwordBox.sendKeys(ConfigurationReader.getProperty("ChQaInvalidPassword"));
        qchp.submitButton.click();
        Assert.assertTrue(qchp.isLoginFailed.isDisplayed());
        Driver.closeDriver();
    }


}
