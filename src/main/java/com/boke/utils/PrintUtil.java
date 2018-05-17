package com.boke.utils;

public class PrintUtil {

    private static boolean flag=true;

    public static void print(String s){
        if(flag){
            System.out.println("**"+s+"**");
        }
    }
}
