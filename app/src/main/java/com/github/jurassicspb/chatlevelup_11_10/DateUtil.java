package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 23.10.2016.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String PATTERN = "HH:mm";

    public static long now() {
        return new Date().getTime();
    }

    public static String fromTs(long ts) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.format(new Date(ts));
    }

}
