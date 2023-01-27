package techproed.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
public class Day21_TechproLoginTest {
    @Test
    public void loginTest(){
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage = new TechproHomePage();

        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));
        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submitButton.click();
//      ASSERTION
//        Login yapildi. Driver su an Home Pagede
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());
//        Sayfadan cikis yap ve cikis yapildigini test et
        techproHomePage.homeLogoutButton.click();
//        Cikis olduguna dair assertion yap
        Assert.assertTrue(techproLoginPage.submitButton.isDisplayed());

//        Driver i kapat
        Driver.closeDriver();
    }
}
