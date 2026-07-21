package com.fpts.fitint.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public final class CommonUtils {
    private static final String CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
    private static final ZoneId VN_ZONE = ZoneId.of("Asia/Ho_Chi_Minh");
    private CommonUtils() {}

    public static String randomStringId(String channel){
        StringBuilder randomString = new StringBuilder();
        for(int i = 0; i < channel.length(); i++){
            int x = ThreadLocalRandom.current().nextInt(CHARS.length());
            randomString.append(CHARS.charAt(x));
        }
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return channel + now + randomString;
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(VN_ZONE);
    }
}
