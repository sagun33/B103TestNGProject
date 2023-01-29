package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class DAy22_US101201_Negative_LoginReservation_HW05 {
    //Name:
    //US101201_Negative_Login
    //Description:
    //Geçerli giriş yapmadan rezervasyon yapamamalı
    //Acceptance Criteria:
    //Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
    //Ve giris yapilmadiginda
    //Hata mesaji almali : Please first login
    //Giris yapildiginda hata mesaji alınmamalı
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test
    public void negative_LoginReservationTest() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("customer_dogruUzantili_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("dogru_sifre"));
        blueRentalLoginPage.loginButton.click();






    }
}
