package com.aegisa.utils;

import java.util.Calendar;
import java.util.Random;

public class IDNumberUtil {

    /**
     * @param no id number to be checked
     * @return true if validated, false if invalid
     */

    public static boolean checkID(String no) {
        if (no == null || no.length() != 18 || !no.matches("\\d{17}[0-9X]")) {
            return false;
        }
        // 1-17位相乘因子数组
        int[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 18位随机码数组
        char[] random = "10X98765432".toCharArray();
        // 计算1-17位与相应因子乘积之和
        int total = 0;
        for (int i = 0; i < 17; i++) {
            total += Character.getNumericValue(no.charAt(i)) * factor[i];
        }
        // 判断随机码是否相等
        return random[total % 11] == no.charAt(17);
    }

    public static String getAgeFromID(String no) {
        if (!checkID(no)) {
            return "非法ID";
        }
        String dob = no.substring(6, 14);
        String yearString = dob.substring(0, 4);
        String monthString = dob.substring(4, 6);
        String dayString = dob.substring(6, 8);
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH) + 1;
        int dayNow = calendar.get(Calendar.DATE);
        int yearMinus = yearNow - year;
        int monthMinus = monthNow - month;
        int dayMinus = dayNow - day;
        int age = yearMinus;
        if (monthMinus < 0) {
            return String.valueOf(age);
        }
        if (monthMinus == 0) {
            if (dayMinus < 0) {
                return String.valueOf(age);
            } else {
                return String.valueOf(age + 1);
            }
        }
        return String.valueOf(age + 1);
    }

    public static String getDOB(String no) {
        if (!checkID(no)) {
            return "非法身份证号码";
        }
        String dob = no.substring(6, 14);
        String yearString = dob.substring(0, 4);
        String monthString = dob.substring(4, 6);
        String dayString = dob.substring(6, 8);
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        return String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
    }

    public static String getGender(String no) {
        if (!checkID(no)) {
            return "非法身份证号码";
        }
        char c = no.charAt(16);
        int gender = c - '0';
        if (gender % 2 == 0) {
            return "女";
        }
        return "男";
    }

    public static String getRandomDOB() {
        //1910-2015
        Random random = new Random();
        int year = random.nextInt(106) + 1910;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(29) + 1;
        return String.valueOf(year) + String.format("%02d", month) + String.format("%02d", day);
    }

    public static String getRandomID(String no_14) {
        Random random = new Random();
        int i = random.nextInt(1000);
        String end3 = String.format("%03d", i);
        String idno = no_14 + end3;
        int[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] ccc = "10X98765432".toCharArray();
        int total = 0;
        for (int i1 = 0; i1 < 17; i1++) {
            total += Character.getNumericValue(idno.charAt(i1)) * factor[i1];
        }
        char c = ccc[total % 11];
        idno += String.valueOf(c);
        return idno;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandomDOB());
        }
    }
}
