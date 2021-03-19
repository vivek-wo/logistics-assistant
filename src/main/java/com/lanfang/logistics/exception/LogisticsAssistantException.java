package com.lanfang.logistics.exception;

import lombok.Getter;

public class LogisticsAssistantException extends RuntimeException {
    @Getter
    private int code;

    public LogisticsAssistantException(int code) {
        this.code = code;
    }

    public LogisticsAssistantException(int code, String message) {
        super(message);
        this.code = code;
    }
}
