package com.itheima.ssm.utis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtis {
    //时间转换字符串
    public String dateToString(Date date,String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat (str);
        String string = simpleDateFormat.format (date);
        return string;
    }
    //字符串转换为时间
    public Date stringToDate(String string,String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat (str);
        Date parse = simpleDateFormat.parse (string);
        return parse;
    }
}
