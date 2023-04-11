package com.oriontech.testngdemo;

import org.testng.annotations.Test;

public class TestPriority {

    @Test
    public void m1() {
        System.out.println("m1");
    }

    @Test
    public void m2() {
        System.out.println("m2");
    }

    @Test
    public void am3() {
        System.out.println("m3");
    }
}
