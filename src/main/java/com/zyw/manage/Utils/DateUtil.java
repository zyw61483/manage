package com.zyw.manage.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil
 *
 * @author: zhaoyiwei
 * @date: 2019/11/14 13:22
 */
public class DateUtil {
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static String toYMD(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(YYYY_MM_DD);
        return simpleDateFormat.format(date);
    }
}
