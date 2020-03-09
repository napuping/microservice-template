package com.nap.up.common.helper;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.nap.up.common.standard.session.Constant.KEY;
import static com.nap.up.common.standard.session.Constant.TOKEN_NAME;

/**
 * @creator napuping
 * @createTime 2020/3/6
 * @description
 */
public class WebHelper {

    private static ServletRequestAttributes servletRequestAttributes() {
        return (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    }
    //得到当前request
    public static HttpServletRequest getRequest() {
        return servletRequestAttributes().getRequest();
    }
    //得到当前response
    public static HttpServletResponse getResponse() {
        return servletRequestAttributes().getResponse();
    }
    //得到当前session
    public static HttpSession getSession() {
        return getRequest().getSession();
    }
    //写cookie
    public static void writeCookie(String name, String value, int time) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(time);
        getResponse().addCookie(cookie);
    }

    //通过HttpResponse写回前端
    public static void writeJson(Object entity) {
        try {
            HttpServletResponse response = getResponse();
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            String json = JSON.toJSONString(entity);
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
