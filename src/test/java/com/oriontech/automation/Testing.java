package com.oriontech.automation;

import org.testng.annotations.Test;

import java.util.*;

public class Testing {


    @Test
    public void testSomeMethod() {
//        Integer a [] = {1,2,4,5,6,7,8};
//        List<Integer> list  = Arrays.asList(a);
//
//        list.toArray();

        int num =0;
        while(true){
            if(num<100){
                System.out.println(num);
                num++;
            }else{
                break;
            }
        }
    }
}
