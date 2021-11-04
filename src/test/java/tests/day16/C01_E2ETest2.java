package tests.day16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QaConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class C01_E2ETest2 {

//3. https://qa-environment.concorthotel.com/ adresine gidin.
// 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
//    a. Username : manager
//    b. Password  : Manager1!
//5. Login butonuna tıklayın.
//6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
//7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//8. Save butonuna basin.
//9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
//10. OK butonuna tıklayın.
//11. Hotel rooms linkine tıklayın.
//12. Bir onceki asamada eklediginiz odanin, odalar listesinde gorundugunu göründüğünü doğrulayın..

    @Test
    public void roomCreateTest () throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("ChQaUrl"));
        QaConcortHotelPage qa = new QaConcortHotelPage();
        qa.loginButton.click();
        qa.userNameBox.sendKeys(ConfigurationReader.getProperty("ChQaValidUserName"));
        qa.passwordBox.sendKeys(ConfigurationReader.getProperty("ChQaValidPassword"));
        qa.submitButton.click();
        qa.hotelManagementButton.click();
        qa.hotelRoomsButton.click();
        qa.addHotelRoomButton.click();
        Thread.sleep(1000);
        Select select = new Select(qa.idHotelOptions);
        List<WebElement> idHotelOptions = select.getOptions();
        int randomidNum = (int) (Math.random()*idHotelOptions.size());
        select.selectByVisibleText(idHotelOptions.get(randomidNum).getText());
        Actions actions = new Actions(Driver.getDriver());
        String roomCode = "12345";
        actions.sendKeys(qa.firstInputBox, roomCode).sendKeys(Keys.TAB).
                sendKeys("Oguzhan").sendKeys(Keys.TAB).
                sendKeys("Turkey").sendKeys(Keys.TAB).sendKeys(Keys.END).
                sendKeys("Aralik'da QA").sendKeys(Keys.TAB).
                sendKeys("700").perform();
        select = new Select(qa.hotelRoomOptions);
        List<WebElement> hotelRoomOptions = select.getOptions();
        int randomRoomNum = (int) (Math.random()*hotelRoomOptions.size());
        select.selectByVisibleText(hotelRoomOptions.get(randomRoomNum).getText());
        actions.sendKeys(qa.adultCountBox, "2").sendKeys(Keys.TAB).
                sendKeys("4").sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).perform();
        qa.submitButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(qa.isSaveSuccessfully)).isDisplayed(),"Test for 'Select Hotel Room Save Button' is failed!");
        qa.okButtonForSuccessSaveMessage.click();
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(1000);
        qa.hotelRoomsButton.click();
        Thread.sleep(1000);
        actions.sendKeys(qa.hotelCodeBox, roomCode).perform();
        qa.searchButtonOnHotelRoom.click();
        Thread.sleep(1000);
        List <String> selectedRoomsString = new ArrayList<>();
        qa.hotelRoomsCodes.stream().forEach(t-> selectedRoomsString.add(t.getText()));
        System.out.println(selectedRoomsString);
        Assert.assertTrue(selectedRoomsString.contains(roomCode),"Test for 'Adding Hotel Room' is failed!");
        Driver.closeDriver();

    }
}
