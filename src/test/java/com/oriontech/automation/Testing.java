package com.oriontech.automation;

import org.testng.annotations.*;

public class Testing {

    @BeforeSuite
    public void testSomeMethod1() {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void testSomeMethod10() {
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void testSomeMethod12() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void testSomeMethod2() {
        System.out.println("BeforeMethod");
    }
    @Test
    public void testSomeMethod() {
        System.out.println("test1");
    }

    @Test
    public void testSomeMethod8() {
        System.out.println("test2");
    }
    @Test
    public void testSomeMethod5() {
        System.out.println("test3");
    }

    @AfterMethod
    public void testSomeMethod3() {
        System.out.println("AfterMethod");
    }

    @AfterSuite
    public void testSomeMethod4() {
        System.out.println("AfterSuite");
    }

    @AfterTest
    public void testSomeMethod11() {
        System.out.println("AfterTest");
    }

    @AfterClass
    public void testSomeMethod13() {
        System.out.println("AfterClass");
    }
}
