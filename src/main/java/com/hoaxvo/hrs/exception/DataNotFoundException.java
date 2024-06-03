package com.hoaxvo.hrs.exception;

import com.hoaxvo.hrs.dto.common.Error;

public class DataNotFoundException extends BaseException {
    public DataNotFoundException(Error error) {
        super(error);
    }
}
