package com.nap.up.common.standard.session;

/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
public enum SessionType {

    REDIS("redis"),
    SESSION("session");

    private String type;
    SessionType(String type) {
        this.type = type;
    }

    public static SessionType judge(String type) {
        SessionType[] values = SessionType.values();
        for(SessionType sessionType : values) {
            if (sessionType.type.equals(type)) {
                return sessionType;
            }
        }
        return null;
    }
}
