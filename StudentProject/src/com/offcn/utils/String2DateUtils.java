package com.offcn.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class String2DateUtils {

    public static Date getDate(String strTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(date.getTime());

    }
}
