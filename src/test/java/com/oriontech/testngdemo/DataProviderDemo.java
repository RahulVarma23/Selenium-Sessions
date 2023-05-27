package com.oriontech.testngdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    //Dataprovider returns 2D array of object

    @DataProvider(name="testing123")
    public Object [] [] testData() {
        return new Object [] [] {
                {"Rahul" , 29},
                {"Laxman" , 30}
        };
    }

    @Test(dataProvider = "testing123")
    public void testMethod(String name, int age) {
        System.out.println("name :"+name +"--> age:"+age);
    }

}
