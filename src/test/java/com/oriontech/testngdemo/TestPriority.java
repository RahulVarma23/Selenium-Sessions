package com.oriontech.testngdemo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPriority {

    @BeforeMethod()
    public void m1() {
        System.out.println("m1");
    }

    @Test(groups="regression")
    public void m4() {
        System.out.println("m4");
    }

    @Test(groups="smoke")
    public void m5() {
        System.out.println("m5");
    }
    @Test(groups="anjuli")
    public void m2() {
        System.out.println("m2");
        Assert.assertTrue("java".equals("java1"));
    }

    @AfterMethod()
    public void m3() {
        System.out.println("m3");
    }
}
