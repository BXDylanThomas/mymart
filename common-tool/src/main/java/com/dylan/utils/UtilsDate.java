package com.dylan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 9:40
 */
public class UtilsDate {

    private static SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
    private static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentTime(){
        return formatTime.format(new Date());
    }

    public static String getCurrentTime(Date date){
        return formatTime.format(date);
    }

    public static String getCurrentDate(){
        return formatDate.format(new Date());
    }

    public static String getCurrentDate(Date date){
        return formatDate.format(date);
    }

}
