package com.smartfactory.apiserver.common.constant;

import java.util.Map;

public class Constant {
    public static final Map<String, String> CLIENT_ID = Map.of(
            "smartfactory", "smartfactory123@#!"
    );

    //for Encrypt
    public static final String ENCRYPT_ALG = "AES/CBC/PKCS5Padding";
    public static final String ENCRYPT_KEY = "01234567899254321111012345678901";
    public static final String ENCRYPT_IV = ENCRYPT_KEY.substring(0, 16); // 16byte
}
