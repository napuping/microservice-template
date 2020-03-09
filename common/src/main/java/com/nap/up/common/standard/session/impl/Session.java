package com.nap.up.common.standard.session.impl;

import com.nap.up.common.helper.WebHelper;
import com.nap.up.common.standard.session.SessionAction;

import javax.servlet.http.HttpSession;
import static com.nap.up.common.standard.session.Constant.*;

/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
public class Session implements SessionAction {

    public String save(Object entity) {
        HttpSession session = WebHelper.getSession();
        String key = KEY + "_" + session.getId();
        session.setAttribute(key, entity);
        return KEY;
    }

    public <T> T get() {
        HttpSession session = WebHelper.getSession();
        String key = KEY + "_" + session.getId();
        return (T)session.getAttribute(key);
    }
}
