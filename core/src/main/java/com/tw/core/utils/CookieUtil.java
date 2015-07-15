package com.tw.core.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yzli on 7/15/15.
 */
public class CookieUtil {

    public static void addCurrentURLToCookies(HttpServletRequest request, HttpServletResponse response) {

        Cookie url = new Cookie("url", request.getRequestURL().toString());
        url.setPath("/");
        response.addCookie(url);
    }
}
