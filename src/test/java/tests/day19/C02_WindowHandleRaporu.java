package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporu extends TestBaseRapor {

    @Test
    public void test () {

        extentTest = extentReports.createTest("Window Handle Test", "Yani Sayfada New Window");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("Istenen adrese gidildi");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("Linke tiklandi");
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfa acildi");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("Test edecegimiz yazi locate edildi");
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        extentTest.info("Yazinin gorunur oldugu test edildi");
        ReusableMethods.waitFor(5);
    }
}
