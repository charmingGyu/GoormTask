package com.example.exception;

import com.example.errorResponse.entity.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.AbstractMap;
import java.util.Map;

@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
    private String message;
    private Map.Entry<String, Object> data;

    @Override
    public String getMessage() {
        if (StringUtils.hasLength(this.message)) {
            return this.message;
        }
        return errorCode.getMessage();
    }

    public CustomException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(), data);
    }
}
