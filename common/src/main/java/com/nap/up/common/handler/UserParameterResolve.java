package com.nap.up.common.handler;

import com.nap.up.common.annotation.UserFlag;
import com.nap.up.common.standard.session.SessionDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Parameter;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
public class UserParameterResolve implements HandlerMethodArgumentResolver {

    @Autowired
    private SessionDirector sessionDirector;

    public boolean supportsParameter(MethodParameter methodParameter) {
        Parameter parameter = methodParameter.getParameter();
        UserFlag userFlag = parameter.getAnnotation(UserFlag.class);
        return userFlag != null;
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object userInfo = sessionDirector.get();
        return userInfo;
    }
}
