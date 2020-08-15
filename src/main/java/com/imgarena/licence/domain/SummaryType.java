package com.imgarena.licence.domain;

public enum SummaryType {
    AvB, AvBTime;

    public static SummaryType build(String summaryType) {
        try {
            return SummaryType.valueOf(summaryType);
        } catch (IllegalArgumentException | NullPointerException e) {
            return AvB; //default value
        }
    }
}
