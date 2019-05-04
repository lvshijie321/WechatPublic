package com.lvshijie.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class CheckUtil {
    private static final String TOKEN = "lvshijie";

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 排序
        String[] arr = new String[3];
        arr[0] = TOKEN;
        arr[1] = timestamp;
        arr[2] = nonce;
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(DigestUtils.md5Hex(sb.toString()));
        System.out.println(signature);
        return signature.equals(DigestUtils.md5Hex(sb.toString()));
    }


}
