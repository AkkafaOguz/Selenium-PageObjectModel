package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class QaConcortHotelPage {

    WebDriver driver;

    public QaConcortHotelPage () {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginButton;

    @FindBy (id = "UserName")
    public WebElement userNameBox;

    @FindBy (id = "Password")
    public WebElement passwordBox;

    @FindBy (id = "btnSubmit")
    public WebElement submitButton;

    @FindBy (xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement isLoginSuccessfully;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement isLoginFailed;

    @FindBy (xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementButton;

    @FindBy (partialLinkText = "Hotel List")
    public WebElement hotelListButton;

    @FindBy (xpath = "//span[.='Add Hotel ']")
    public WebElement addHotelButton;

    @FindBy (xpath = "//input[@id='Code']")
    public WebElement firstInputBox;

    @FindBy (xpath = "//select[@id='IDGroup']")
    public WebElement idGroupOptions;

    @FindBy (xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement isSaveSuccessfully;

    @FindBy (xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButtonForSuccessSaveMessage;

    @FindBy (partialLinkText = "Hotel Room")
    public WebElement hotelRoomsButton;

    @FindBy (xpath = "//span[.='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy (xpath = "//select[@name='IDHotel']")
    public WebElement idHotelOptions;

    @FindBy (xpath = "//select[@id='IDGroupRoomType']")
    public WebElement hotelRoomOptions;

    @FindBy (xpath = "//input[@id='MaxAdultCount']")
    public WebElement adultCountBox;

    @FindBy (xpath = "//input[@name='Code']")
    public WebElement hotelCodeBox;

    @FindBy (xpath = "//button[.='Search']")
    public WebElement searchButtonOnHotelRoom;

    @FindBy (xpath = "//tbody//td[3]")
    public List <WebElement> hotelRoomsCodes;






    public void ConcortHotelLogin() {

        Driver.getDriver().get(ConfigurationReader.getProperty("ChQaUrl"));
        QaConcortHotelPage qchp = new QaConcortHotelPage();
        qchp.loginButton.click();
        qchp.userNameBox.sendKeys(ConfigurationReader.getProperty("ChQaValidUserName"));
        qchp.passwordBox.sendKeys(ConfigurationReader.getProperty("ChQaValidPassword"));
        qchp.submitButton.click();
    }
}
