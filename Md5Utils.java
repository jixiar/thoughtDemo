package com.dcml.cms.util;

import org.springframework.util.DigestUtils;

public class Md5Utils {

    public static String md5Encode(String text) {
        String encodeStr = DigestUtils.md5DigestAsHex(text.getBytes());
        return encodeStr;
    }

}
