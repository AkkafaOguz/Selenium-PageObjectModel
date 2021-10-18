package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {

    // Amazon sayfasina gidip Nutella icin arama yapin
    // Sonuc sayisini yazdirin ve bu yazinin Nutella icerdigini test edin

    @Test
    public void test() {

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        WebElement resulTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resulTextElement.getText());
        Assert.assertTrue(resulTextElement.getText().contains("Nutella"),"Test for 'Result Text Part' is failed!");

    }

    @Test
    public void testPOM() {

        driver.get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        Assert.assertTrue(amazonPage.resultTextElement.getText().contains("Nutella"));



    }



}
