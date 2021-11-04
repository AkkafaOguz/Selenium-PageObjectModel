package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tekrar extends TestBaseRapor {


    @Test
    public void test(){

        extentTest = extentReports.createTest("Window Handle Test","Yeni sayfada window yazisi");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("Istenen adrese gidildi");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("Link'e tiklandi");
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("Yeni sayfaya gecildi");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("Test edecegimiz yazi locate edildi");
        Assert.assertFalse(newWindowYaziElementi.isDisplayed());
        extentTest.pass("Yazinin gorunur oldugu test edildi");

    }


    @Test
    public void test1(){


        String dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:m:ss").format(new Date());
        System.out.println(dateFormat);
    }
}
