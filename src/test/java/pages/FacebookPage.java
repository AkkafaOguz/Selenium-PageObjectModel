package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage (WebDriver a) {

        this.driver=a;
        PageFactory.initElements(a,this);

    }

    @FindBy (id = "email")
    public WebElement mailBox;

    @FindBy (id = "pass")
    public WebElement password;

    @FindBy (xpath = "//button[@name='login']")
    public WebElement loginButton;
}
