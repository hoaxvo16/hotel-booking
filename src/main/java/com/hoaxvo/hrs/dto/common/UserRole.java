package com.hoaxvo.hrs.dto.common;

public enum UserRole {
    ADMIN("ADMIN", "Role for administration "),
    USER("USER", "Role for normal user");

    public final String name;
    public final String desc;

    UserRole(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
