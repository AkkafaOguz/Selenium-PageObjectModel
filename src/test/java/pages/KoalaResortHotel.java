package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class KoalaResortHotel {

    WebDriver driver;

    public KoalaResortHotel () {

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

    @FindBy (xpath = "//h1[.='Bağlantınız gizli değil']")
    public WebElement connectionIssue;



    public void koalaLogin() {

        Driver.getDriver().get(ConfigurationReader.getProperty("koalaUrl"));

        if (connectionIssue.isDisplayed()){
            Driver.getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
            Driver.getDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
        }

        loginButton.click();
        userNameBox.sendKeys(ConfigurationReader.getProperty("koalaValidUsername"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("koalaValidPassword"));
        submitButton.click();

    }
}
