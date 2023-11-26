package com.abdelrahman.schoolmanagementsystem.Enums;

public enum Period {
    PERIOD_1("8:9"),
    PERIOD_2("9:10"),
    PERIOD_3("10:11"),
    PERIOD_4("11:12"),
    PERIOD_5("12:1"),
    PERIOD_6("1:2");


    final String duration;

    Period(String duration) {
        this.duration = duration;

    }
}
