package com.hoaxvo.hrs.exception;

import com.hoaxvo.hrs.dto.common.ResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseDTO<?> dataNotFoundExceptionHandler(DataNotFoundException exception) {
        return exception.createErrorResponse();
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseDTO<?> invalidArgumentExceptionHandler(InvalidArgumentException exception) {
        return exception.createErrorResponse();
    }
}
