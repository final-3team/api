package com.smartfactory.apiserver.common.util;


import java.util.UUID;

public class StringUtil {
    public static String generateUUID() {
        UUID uuidObj = UUID.randomUUID();
        return uuidObj.toString();
    }

    public static boolean isEmpty(String value){
        if(value == null || value.isEmpty()){
            return true;
        }
        return false;
    }
    public static String replaceKakaoPhoneNumber(String phoneNumber){
        String value = null;
        if(phoneNumber != null){
            value = "0" + phoneNumber.replace("+82", "").trim();
        }
        return value;
    }
}
