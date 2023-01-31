package techproed.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
public class BlueRentalLoginPage {
    public BlueRentalLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "password")
    public WebElement passwordBox;



    @FindBy(xpath = "//*[text()='Bad credentials']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//*[.='Bad credentials'])[2]")
    public WebElement badCredentialsMassage;

    @FindBy(xpath = "//*[.='email must be a valid email']")
    public WebElement invalidEmail;

    @FindBy(name = "email")
    public WebElement userName;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='email must be a valid email']")
    public WebElement invalid_Email_Message;

}
