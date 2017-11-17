package com.wang.wei.web;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie宸ュ叿绫�
 * 
 */
public class CookieUtil {

    private CookieUtil() {
    }

    /**
     * 娣诲姞cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 鍒犻櫎cookie
     * 
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }

    /**
     * 鑾峰彇cookie鍊�
     * 
     * @param request
     * @return
     */
    public static String getUid(HttpServletRequest request,String cookieName) {
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}