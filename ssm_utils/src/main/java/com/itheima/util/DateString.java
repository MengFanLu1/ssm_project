package com.itheima.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateString {

    public static String date2String(Date date,String patt){
        SimpleDateFormat format = new SimpleDateFormat(patt);

        String str = format.format(date);

        return str;
    }

    public static Date date2String(String str,String patt) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(patt);

        Date date = format.parse(str);

        return date;
    }

}
