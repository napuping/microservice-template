package com.nap.up.front.source;

import java.util.Base64;

/**
 * @creator napuping
 * @createTime 2020/3/8
 * @description
 */
public class SourceCode {
    public static void main(String[] args) {
        byte[] decode = Base64.getDecoder().decode("QUFodHRwOi8vdG9vbC5sdS90ZXN0LnppcFpa");
        System.out.println(new String(decode));
    }
}
