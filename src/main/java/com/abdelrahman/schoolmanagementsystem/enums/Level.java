package com.abdelrahman.schoolmanagementsystem.enums;

import lombok.Getter;

@Getter
public enum Level {
    ELEMENTARY("E"),
    MIDDLE("M"),
    HIGH_SCHOOL("H");

    final String abbreviation;


    Level(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
