package com.hoaxvo.hrs.exception;

import com.hoaxvo.hrs.dto.common.Error;
import com.hoaxvo.hrs.dto.common.ErrorDTO;
import com.hoaxvo.hrs.dto.common.ResponseDTO;
import lombok.Getter;

import java.util.List;

public class BaseException extends RuntimeException {
    @Getter
    protected String code;
    protected String message;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Error error) {
        this.code = error.code;
        this.message = error.message;
    }

    public ResponseDTO<?> createErrorResponse() {
        ResponseDTO<?> responseDTO = new ResponseDTO<>();
        responseDTO.setErrors(List.of(new ErrorDTO(this.code, this.message)));
        return responseDTO;
    }
}
