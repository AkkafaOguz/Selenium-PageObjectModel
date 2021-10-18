package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_PagesAmazon extends TestBase {

    // amazon sayfasina gidin
    // dropdown menuden book kategorisini secin
    // java icin arama yapin
    // bulunan sonuc sayisini yazdirin
    // ilk urunun adinda Java gectigini test edin

    @Test
    public void test () {

        driver.get("https://www.amazon.com");
        AmazonPage ap = new AmazonPage(driver);
        Select select = new Select(ap.dropDown);
        select.selectByValue("search-alias=stripbooks-intl-ship");
        ap.searchBox.sendKeys("java" + Keys.ENTER);
        System.out.println(ap.resultTextElement.getText());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText().contains("Java"));

    }
}
