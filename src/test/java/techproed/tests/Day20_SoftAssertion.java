package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {
    @Test
    public void testsoftAssertTest() {
        //1.Soft Assert objesi olustur
        SoftAssert softAssert=new SoftAssert();
        System.out.println("Satir 14");
        softAssert.assertEquals(2,5);
        System.out.println("Satir 16");
        softAssert.assertTrue("Java".contains("U"));
        System.out.println("Satir 18");
        softAssert.assertTrue(true);
        System.out.println("Satir 28");
        softAssert.assertAll();
    }
}
