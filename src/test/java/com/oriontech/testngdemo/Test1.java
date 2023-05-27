package com.oriontech.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 {

    @Test
    public void m1 () {
        System.out.println("print1");
        Assert.assertTrue(false);
        System.out.println("print2");
    }

    @Test
    public void m2 () {
        System.out.println("print1");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        System.out.println("print2");
        softAssert.assertEquals(1, 2);
        System.out.println("print3");
        softAssert.assertEquals("java", "java");
        System.out.println("print4");
        softAssert.assertAll();
    }
}
