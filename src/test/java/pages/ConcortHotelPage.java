package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;

    public ConcortHotelPage (WebDriver x) {

        PageFactory.initElements(x,this);
        this.driver = x;
    }

    @FindBy (linkText = "Log in")
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


}
