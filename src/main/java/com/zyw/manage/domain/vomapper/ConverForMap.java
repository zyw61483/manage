package com.zyw.manage.domain.vomapper;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ConverForMap {
    public String booleanToString(boolean value) {
        if (value) {
            return "Y";
        }
        return "N";
    }
    public boolean strToBoolean(String str) {
        if ("Y".equals(str)) {
            return true;
        }
        return false;
    }
    public Date longToDate(Long value) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value == null) {
            return null;
        }
        return new Date(value);
    }
    public Long dateToLong(Date value) {
        if (value == null) {
            return null;
        }
        return value.getTime();
    }
    public String longToString(Long value) {
        if (value == null) {
            return null;
        }
        return String.valueOf(value);
    }
    public Long stringToLong(String value) {
        if (value == null) {
            return 0l;
        }
        return Long.parseLong(value);
    }
    public Date stringToDate(String value) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value == null) {
            return null;
        }
        try {
            return format.parse(value);
        } catch (ParseException e) {
            try {
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                return format1.parse(value);
            }catch (ParseException e1) {
                log.error("stringToDate异常", e1);
                return null;
            }
        }
    }
    public String dateToString(Date value) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value == null) {
            return null;
        }
        return format.format(value);
    }
}
