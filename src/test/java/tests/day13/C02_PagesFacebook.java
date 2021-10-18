package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    // Login sayfasina gidin
    // Kullanici adi : techproed
    // sifre : 12345
    // yazarak giris yapamadigimizi test edelim

    @Test
    public void test () throws InterruptedException {

        driver.get("https://www.facebook.com");
        FacebookPage fp = new FacebookPage(driver);
        fp.mailBox.sendKeys("techproed");
        fp.password.sendKeys("12345");
        fp.loginButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='_9ay6 img']")).isDisplayed(),"Test for 'Fail to login' is failed!");

    }
}
