package org.example.scene.str;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 日期（字符串格式）相关操作
 * @Author shengy
 * @Date 2024/10/17 13:45
 */
public class DateOperator {
    public static void main(String[] args) {
        String date = "202405";
        List<String> strings = firstNineMonths(date, 12);
        System.out.println(strings);
    }

    // 根据传入的日期字符串匹配是否符合202101这样的格式
    private static boolean isValidMonthDate(String date) {
        String regex = "^\\d{4}(0[1-9]|1[0-2])$";
        return date.matches(regex);
    }


    // 根据传入的形如202405类型的日期字符串返回前n个月日期集合
    private static List<String> firstNineMonths(String date, int n) {
        ArrayList<String> monthList = new ArrayList<>();
        if (!isValidMonthDate(date)){
            return monthList;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        YearMonth parsed = YearMonth.parse(date, formatter);
        monthList.add(parsed.format(formatter));
        for (int i = 0; i < n - 1; i++) {
            parsed = parsed.minusMonths(1);
            monthList.add(parsed.format(formatter));
        }

        return monthList;
    }














}
