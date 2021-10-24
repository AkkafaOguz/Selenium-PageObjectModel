package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
    // Bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey driver'a bir constructor olusturup ilk degeri atamaktir. (Instantiate)

    public AmazonPage (WebDriver a) {

        PageFactory.initElements(a,this);
        this.driver = a;
    }

    @FindBy (id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultTextElement;

    @FindBy (xpath = "//select[@aria-describedby='searchDropdownDescription']")
    public WebElement dropDown;

//Selamlar
}
