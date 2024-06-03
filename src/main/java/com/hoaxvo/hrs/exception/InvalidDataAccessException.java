package com.hoaxvo.hrs.exception;

import com.hoaxvo.hrs.dto.common.Error;

public class InvalidDataAccessException extends BaseException {
    public InvalidDataAccessException(String message) {
        super(message);
    }

    public InvalidDataAccessException(Error error) {
        super(error);
    }
}
