package techproed.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day20_DependsOnMethods {
    @Test
    public void homeTest(){
        System.out.println("Home Test");
        Assert.assertTrue(true);//FAIL
    }
    @Test(dependsOnMethods = "homeTest")
    public void searchTest(){
        System.out.println("Search Test");
    }
    @Test(dependsOnMethods = "homeTest")
    public void paymentTest(){
        System.out.println("Payment Test");
    }
}
/*
TestNG de tum  @Test metotlar birbirlerinden bagimsiz olarak calisirlar
Eger methodlari bagimli hale getirmek istersem, dependsOnMethods parametresi kullanilir
Burdaki ornekde, searchTest methodu homeTest methoduna bagimlidir
searchTest den once homeTest calisir
Eger homeTest basarili ise searchTest calisir.
Eget homeTest basarisiz ise, searchTest IGNORE edilir
 */

