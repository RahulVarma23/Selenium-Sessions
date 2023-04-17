package com.oriontech.testngdemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {

    int count =1;

    public static void main(String[] args) {
        Test2 t = new Test2();
        t=null;
        System.out.println(t.count);
    }

    @Parameters("browser")
    @Test
    public void testParameter( String browser) {
        System.out.println("Browser is: "+browser);
    }

    @Parameters("browser")
    @Test
    public void tets( String browser) {
        System.out.println("Browser is: "+browser);
    }
}
