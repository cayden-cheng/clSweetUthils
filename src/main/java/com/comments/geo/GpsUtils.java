package com.comments.geo;

/**
 * @author chengliang
 * @date 2019/11/28 11:36
 * 计算两个经纬度之间的距离
 */
public class GpsUtils {
    private static double EARTH_RADIUS = 6371.393;

    /**
     * 有效的经度范围
     */
    public static boolean isValidLongitude(double longitude) {
        return longitude > -180 && longitude < 180;
    }

    /**
     * 有效的纬度范围
     */
    public static boolean isValidLatitude(double latitude) {
        return latitude > -85.05112878 && latitude < 85.05112878;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     */
    public static double geoDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }
}
