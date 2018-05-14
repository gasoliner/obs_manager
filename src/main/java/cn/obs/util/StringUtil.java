package cn.obs.util;

/**
 * Created by cqx on 2018/5/13.
 */
public class StringUtil {

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0 && s != "";
    }
}
