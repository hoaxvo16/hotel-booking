package com.hoaxvo.hrs.dto.common;

public enum Error {
    DE001("DE001", "Cannot find user"),
    DE002("DE002", "Cannot find room"),
    DE003("DE003", "Cannot find reservation"),
    DE004("DE004", "The given room id has been reserved"),
    IE001("IE001", "Check in date must not after check out date");


    public final String code;
    public final String message;

    Error(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
