package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class DAy22_US101122_Negative_Login_HW04 {
    //Name:
    //US101122_Negative_Login
    //Description:
    //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
    //Acceptance Criteria:
    //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
    //Error Message: email must be a valid email
    //Dogru email uzantisi girildiğinde hata mesajı alınmamalı
    //https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
    //email-verify.my-addr.comemail-verify.my-addr.com
    //List of most popular email domains (by number of live emails)
    //Top 100 - List of most popular email domains according to number of live email addreses.

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test
    public void negativeLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("customer_yanlis_zantili_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("dogru_sifre"));
        blueRentalLoginPage.loginButton.click();
        Assert.assertTrue(blueRentalLoginPage.invalidEmail.isDisplayed());


        Driver.closeDriver();

    }
    @Test
    public void positiveLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("customer_dogruUzantili_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("dogru_sifre"));
        blueRentalLoginPage.loginButton.click();

        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
        Driver.closeDriver();

    }
}
