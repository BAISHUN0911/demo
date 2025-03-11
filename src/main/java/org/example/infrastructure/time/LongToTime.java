package org.example.infrastructure.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/24 16:22
 */
public class LongToTime {
    public static void main(String[] args) {
        System.out.println("当前系统所在时区: " + ZoneId.systemDefault());
        Long l = 1718093295707L;
        Instant instant = Instant.ofEpochMilli(l);
        // 指定instant 和 时区
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = dateTime.format(formatter);
        System.out.println(formatDateTime);
    }
}
