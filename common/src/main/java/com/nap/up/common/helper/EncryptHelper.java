package com.nap.up.common.helper;

import java.security.MessageDigest;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
public class EncryptHelper {

    //md5加密
    public static String md5(String source, String malt) {
        StringBuffer sb = new StringBuffer(32);
        try {
            source += malt;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(source.getBytes("utf-8"));

            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }

}
