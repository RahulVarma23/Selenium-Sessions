package com.oriontech.testngdemo;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    static int a =10;
    public static void main(String[] args) {
        String s1 = "rahul";
        String s2 = "varma";


    }

    public static String reverses(String s){
        if(s==null || s.length()<=1 ){
            return s;
        }

        String rev = "";
        for(int i=s.length()-1;i>=0;i--){
            rev += s.charAt(i);
        }
        return rev;
    }
}
