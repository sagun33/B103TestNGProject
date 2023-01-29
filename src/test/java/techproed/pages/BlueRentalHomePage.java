package techproed.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLInputElement;
import techproed.utilities.Driver;

public class BlueRentalHomePage {


    public BlueRentalHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;

    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;
    @FindBy(xpath = "//select[@name='car']")
    public WebElement selectACar;
    @FindBy(name = "pickUpLocation")
    public WebElement pickUpLocation;
    @FindBy(name = "dropOfLocation")
    public WebElement dropOfLocation;
    @FindBy(name = "pickUpDate")
    public WebElement pickUpDate;
    @FindBy(name = "pickUpTime")
    public WebElement pickUpTime;
    @FindBy(name = "dropOffDate")
    public WebElement dropOffDate;
    @FindBy(name = "dropOffTime")
    public WebElement dropOffTime;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservationButton;
    @FindBy(xpath = "//div[.='Please first login']")
    public WebElement pleaseFirstLogin;
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;


}











