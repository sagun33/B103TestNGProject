//package techproed.tests.smoketests;
//
//import com.github.javafaker.Faker;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//import techproed.pages.BlueRentalHomePage;
//import techproed.pages.BlueRentalLoginPage;
//import techproed.utilities.ConfigReader;
//import techproed.utilities.Driver;
//import techproed.utilities.ReusableMethods;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Calendar;
//import java.util.Locale;
//
//public class HW_3_4_5_NegativeLoginTests {
//    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
//    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
//
//
//    @Test
//    public void US100402_Negative_LoginCorrectEMailIncorrectPassword(){
//
////        Name:
////US100402_Negative_Login
////Description:
////Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
////Acceptance Criteria:
////Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
////Hata Mesaji:
////Bad credentials
////Test Data:
////Customer email: jack@gmail.com
////Customer password: fakepass
//        //Error: Bad credentials
//        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        blueRentalHomePage.loginLink.click();
//        blueRentalLoginPage.userName.sendKeys(ConfigReader.getProperty("admin_email"));
//        blueRentalLoginPage.password.sendKeys(Faker.instance().internet().password());
//        blueRentalLoginPage.loginButton.click();
//        ReusableMethods.waitFor(3);
//        ReusableMethods.verifyElementDisplayed(blueRentalLoginPage.errorMessage);
//    }
//
//    @Test
//    public void US101122_Negative_LoginWithIncorrectEMail(){
//
////        Name:
////US101122_Negative_Login
////Description:
////Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
////Acceptance Criteria:
////Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
////Error Message: email must be a valid email
////Dogru email uzantisi girildiğinde hata mesajı alınmamalı
////https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
////email-verify.my-addr.comemail-verify.my-addr.com
////List of most popular email domains (by number of live emails)
////Top 100 - List of most popular email domains according to number of live email addreses.
//        //Error message : email must be a valid email
//        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        blueRentalHomePage.loginLink.click();
//        blueRentalLoginPage.userName.sendKeys(Faker.instance().name().username());
//        ReusableMethods.verifyElementDisplayed(blueRentalLoginPage.invalid_Email_Message);
//    }
//    @Test
//    public void US101201_Negative_LoginReservation(){
//
////        Name:
////US101201_Negative_Login
////Description:
////Geçerli giriş yapmadan rezervasyon yapamamalı
////Acceptance Criteria:
////Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
////Ve giris yapilmadiginda
////Hata mesaji almali : Please first login
////Giris yapildiginda hata mesaji alınmamalı
//        //Error message : Please first login
//        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        //Select a car
//        Select car = new Select(blueRentalHomePage.selectACar);
//        car.selectByValue("10");
//        blueRentalHomePage.pickUpLocation.sendKeys(Faker.instance(Locale.JAPAN).address().cityName());
//        blueRentalHomePage.dropOfLocation.sendKeys(Faker.instance(Locale.JAPAN).address().cityName());
////        Pick Up date
////        Pick Up time
////        Drop Off date
////        Drop Off time
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmaa");
//        Calendar calendar = Calendar.getInstance();
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDate = dtf.format(currentDate);
//        blueRentalHomePage.pickUpDate.sendKeys(formattedDate);
//        blueRentalHomePage.pickUpTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
//        blueRentalHomePage.dropOffDate.sendKeys("05.02.2023");
//        blueRentalHomePage.dropOffTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
//        blueRentalHomePage.continueReservationButton.click();
//        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.pleaseFirstLogin);
//    }
//    @AfterClass
//    public void closeDriver(){
//        Driver.closeDriver();
//    }
//}