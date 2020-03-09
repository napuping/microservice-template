package com.nap.up.common.interceptor;

import com.nap.up.common.annotation.NoLogin;
import com.nap.up.common.entity.vo.Result;
import com.nap.up.common.helper.WebHelper;
import com.nap.up.common.standard.session.SessionDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionDirector sessionDirector;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //静态资源放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        NoLogin noLogin = handlerMethod.getMethodAnnotation(NoLogin.class);
        if (noLogin != null) {
            return true;
        }
        Object object = sessionDirector.get();
        if (object == null) {
            WebHelper.writeJson(Result.unLogin());
            return false;
        }
        return true;
    }
}
