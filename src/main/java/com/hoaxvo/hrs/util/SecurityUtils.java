package com.hoaxvo.hrs.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static String getUserNameFromContext() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    private SecurityUtils() {

    }
}
