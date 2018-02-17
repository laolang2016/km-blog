package com.laolang.kmblog.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static boolean isEmpty( String str){
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty( String str){
        return !isEmpty(str);
    }
}
