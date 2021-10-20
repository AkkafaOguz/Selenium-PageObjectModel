package tests.smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QaConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class E2ETest {

//1. Tests packagenin altına class olusturun: D17_CreateHotel
//2. Bir metod olusturun: createHotel
//3. https://qa-environment.concorthotel.com/ adresine git.
//4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
//    a. Username : manager
//    b. Password  : Manager1!
//5. Login butonuna tıklayın.
//6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
//7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//8. Save butonuna tıklayın.
//9. “Hotel was inserted successfully” textinin göründüğünü test edin.
//10. OK butonuna tıklayın.

    @Test
    public void test () {
        QaConcortHotelPage qchp = new QaConcortHotelPage();
        qchp.ConcortHotelLogin();
        qchp.hotelManagementButton.click();
        qchp.hotelListButton.click();
        qchp.addHotelButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(qchp.firstInputBox, "Hello World").sendKeys(Keys.TAB)
                .sendKeys("Oguzhan").sendKeys(Keys.TAB)
                .sendKeys("Turkey").sendKeys(Keys.TAB)
                .sendKeys("534 655 84 93").sendKeys(Keys.TAB)
                .sendKeys("akkafaoguz@gmail.com").sendKeys(Keys.TAB).perform();

        Select select = new Select(qchp.idGroupOptions);
        select.selectByValue("1");
        qchp.saveButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(qchp.isSaveSuccessfully)).isDisplayed());
        qchp.okButtonForSuccessSaveMessage.click();


    }
}
