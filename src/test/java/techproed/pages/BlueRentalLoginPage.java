package techproed.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;git
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.sql.Driver;

public class BlueRentalLoginPage {
    public BlueRentalLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "email")
    public WebElement emailBox;
    @FindBy(name = "password")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath="//div[@role='alert']")
    public WebElement error_message_1;
}
