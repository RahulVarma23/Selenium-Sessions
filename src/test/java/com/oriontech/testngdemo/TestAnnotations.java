package com.oriontech.testngdemo;

import org.testng.annotations.*;

public class TestAnnotations {

    @BeforeSuite
    public void m1() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void m2() {
        System.out.println("AfterSuite");
    }

    @BeforeTest
    public void m3() {
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void m4() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void m5() {
        System.out.println("BeforeMethod");
    }

    @Test
    public void m6() {
        System.out.println("Test1");
    }

    @Test
    public void m7() {
        System.out.println("Test2");
    }

    @AfterMethod
    public void m8() {
        System.out.println("AfterMethod");
    }
}
