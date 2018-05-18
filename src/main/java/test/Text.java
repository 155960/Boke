package test;

import org.codehaus.jackson.map.util.JSONPObject;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
       /* String s="{'name':'tiger','age':21,'bir':'2018-04-08'}";
       *//* Instant instant=Instant.now();
        int day=instant.get(ChronoField.DAY_OF_MONTH);*//*
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("**"+day+"**"+month);*/
        String s="/home/ftp/";
        String[] a=s.split("/");
        System.out.println(a.length+"*"+a.toString());
        //JSONPObject object=new JSONPObject(s);
    }
}
