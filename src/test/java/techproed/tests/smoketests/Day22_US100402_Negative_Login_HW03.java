package techproed.tests.smoketests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Day22_US100402_Negative_Login_HW03 {
    Faker faker=new Faker();


    //Name:
    //US100402_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
    //Acceptance Criteria:
    //Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
    //Hata Mesaji:
    //Bad credentials
    //Test Data:
    //Customer email: jack@gmail.com
    //Customer password: fakepass
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;


    @Test
    public void negativeLoginTest1() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();

        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("dogru_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("yanlis_sifre"));
        blueRentalLoginPage.loginButton.click();

        Thread.sleep(3000);
        assert blueRentalLoginPage.badCredentialsMassage.getText().contains("Bad credentials");

        assert blueRentalLoginPage.badCredentialsMassage.isDisplayed();

        Thread.sleep(3000);
        Driver.closeDriver();

    }

    ////Name:
    //    //US101122_Negative_Login
    //    //Description:
    //    //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
    //    //Acceptance Criteria:
    //    //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
    //    //Error Message: email must be a valid email
    //    //Dogru email uzantisi girildiğinde hata mesajı alınmamalı
    //    //https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
    //    //email-verify.my-addr.comemail-verify.my-addr.com
    //    //List of most popular email domains (by number of live emails)
    //    //Top 100 - List of most popular email domains according to number of live email addreses.


    @Test
    public void negativeLoginTest2() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();

        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("gecersiz_uzantili_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("dogru_sifre"));
        blueRentalLoginPage.loginButton.click();

        Assert.assertTrue(blueRentalLoginPage.invalidEmail.isDisplayed());


    }

    @Test
    public void negativeLoginTest3() {
        //Error message : Please first login
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //Select a car
        Select car = new Select(blueRentalHomePage.selectACar);
        car.selectByValue("10");
        blueRentalHomePage.pickUpLocation.sendKeys(Faker.instance(Locale.JAPAN).address().cityName());
        blueRentalHomePage.dropOfLocation.sendKeys(Faker.instance(Locale.JAPAN).address().cityName());
//        Pick Up date
//        Pick Up time
//        Drop Off date
//        Drop Off time
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmaa");
        Calendar calendar = Calendar.getInstance();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dtf.format(currentDate);
        blueRentalHomePage.pickUpDate.sendKeys(formattedDate);
        blueRentalHomePage.pickUpTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.dropOffDate.sendKeys("05.02.2023");
        blueRentalHomePage.dropOffTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.continueReservationButton.click();
        Assert.assertTrue(blueRentalHomePage.pleaseFirstLogin.isDisplayed());

    }
    @AfterClass
    public void closeDriver(){
        Driver.closeDriver();

    }
}

