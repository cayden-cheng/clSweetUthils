package com.utils;

/**
 * @Author: cl
 * @Date: 2019/11/27 17:51
 * @Version 1.0
 */
public class StringUtils {


    /**
     * 判空方法,不能判"   ",等同于StringUtils.isEmpty()方法
     */

    public static boolean isEmpty(CharSequence cs) {
        if (cs == null || cs.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判空非空方法,不能判"",等同于StringUtils.isNotEmpty()方法
     */

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判空方法，等同于isBlack()
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                //空格检查
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }


    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    @SafeVarargs
    public static <T> String join(T... elements) {
        return join((Object[]) elements, (String) null);
    }

    public static String join(Object[] array, String separator) {
        return array == null ? null : join((Object[]) array, separator, 0, array.length);
    }

    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }

        if (separator == null) {
            separator = "";
        }

        int noOfItems = endIndex - startIndex;
        if (noOfItems <= 0) {
            return "";
        }
        StringBuilder buf = newStringBuilder(noOfItems);

        for (int i = startIndex; i < endIndex; ++i) {
            if (i > startIndex) {
                buf.append(separator);
            }

            if (array[i] != null) {
                buf.append(array[i]);
            }
        }

        return buf.toString();
    }

    private static StringBuilder newStringBuilder(int noOfItems) {
        return new StringBuilder(noOfItems * 16);
    }
}
