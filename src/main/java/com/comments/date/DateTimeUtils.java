package com.comments.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author chengliang
 * @date 2019/11/28 11:35
 */
public class DateTimeUtils {

    public static final long SECOND_IN_ONE_MINUTE = 60;

    public static final long SECOND_IN_ONE_HOUR = SECOND_IN_ONE_MINUTE * 60;

    public static final long SECOND_IN_6HOURS = SECOND_IN_ONE_HOUR * 6;

    public static final long SECOND_IN_8HOURS = SECOND_IN_ONE_HOUR * 8;

    public static final long SECOND_IN_ONE_DAY = SECOND_IN_ONE_HOUR * 24;

    public static final long MILLS_IN_ONE_SECOND = 1000;

    public static final long MILLS_IN_ONE_MINUTE = MILLS_IN_ONE_SECOND * 60;

    public static final long MILLS_IN_ONE_HOUR = MILLS_IN_ONE_MINUTE * 60;

    public static final long MILLS_IN_ONE_DAY = MILLS_IN_ONE_HOUR * 24;

    public static long endOfDay(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime().getTime();
    }

    public static boolean isEndOfDay(long mills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(mills));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        return hour == 23 && minute == 59 && second == 59 && millisecond == 999;
    }

    public static long startOfDay(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static boolean isStartOfDay(long mills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(mills));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        return hour == 0 && minute == 0 && second == 0 && millisecond == 0;
    }

    /**
     * 计算从此时到今天结束还剩多长时间，单位毫秒
     */
    public static long nowToEndOfToday() {
        Date today = new Date();
        return endOfDay(today) - today.getTime();
    }


    /**
     * 判断给定的时间戳是否是 0分0秒0毫秒
     */
    public static boolean isStartOfHour(long mills) {
        Date date = new Date(mills);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        return minute == 0 && second == 0 && millisecond == 0;
    }

    public static long endOfHour(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(millis));
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime().getTime();
    }

    /**
     * 判断给定的时间戳是否是 59分59秒999毫秒
     */
    public static boolean isEndOfHour(long mills) {
        Date date = new Date(mills);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        return minute == 59 && second == 59 && millisecond == 999;
    }


    /**
     * 获取给定时间戳的小时数
     */
    public static int getHour(long mills) {
        Date date = new Date(mills);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}
