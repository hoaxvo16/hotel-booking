package com.hoaxvo.hrs.exception;

import com.hoaxvo.hrs.dto.common.Error;

public class InvalidArgumentException extends BaseException {
    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(Error error) {
        super(error);
    }
}
