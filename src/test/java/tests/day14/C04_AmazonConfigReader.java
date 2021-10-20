package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C04_AmazonConfigReader extends TestBase {

    // Amazon sayfasina gidip Nutella icin arama yapin
    // Sonuc sayisini yazdirin ve bu yazinin Nutella icerdigini test edin


    @Test
    public void test() {

        driver.get(ConfigurationReader.getProperty("AmazonUrl"));
        AmazonPage ap = new AmazonPage(driver);
        ap.searchBox.sendKeys(ConfigurationReader.getProperty("AmazonSearchKey") + Keys.ENTER);
        System.out.println(ap.resultTextElement.getText());
        Assert.assertTrue(ap.resultTextElement.getText().contains(ConfigurationReader.getProperty("AmazonSearchKey")));
    }
}
