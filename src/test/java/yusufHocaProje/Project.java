package yusufHocaProje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Project extends TestBase {

    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

    clickAllElements
    getName
    compareTwoList

     */

    ArrayList <String> nameOfProducts = new ArrayList<>();

    @Test
    public void getName () {

        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.linkText("Phones & PDAs")).click();
        List <WebElement> nameBoxOfProducts = driver.findElements(By.xpath("//div[@class= 'caption']//h4"));
        nameBoxOfProducts.stream().forEach(t-> nameOfProducts.add(t.getText()));
        nameOfProducts.stream().forEach(t-> System.out.println("--> " + t));

    }

    @Test (dependsOnMethods = "getName")
    public void clickAllElements () {

        List <WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains (@onclick, 'cart.add')]"));
        addToCartButtons.stream().forEach(t-> t.click());

    }

    @Test (dependsOnMethods = "clickAllElements")
    public void compareTwoList () throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id= 'cart-total']")));
        cartButton.click();
        List <WebElement> productNameBoxInTheCartList = driver.findElements(By.xpath("//td[@class= 'text-left']//a"));
        ArrayList <String> productNameInTheCartList = new ArrayList<>();
        productNameBoxInTheCartList.stream().forEach(t-> productNameInTheCartList.add(t.getText()));

        Collections.sort(nameOfProducts);
        Collections.sort(productNameInTheCartList);

        Assert.assertEquals(nameOfProducts,productNameInTheCartList,"Test fot 'Comparing Cart List with choosed Products' is failed!");


    }


}
