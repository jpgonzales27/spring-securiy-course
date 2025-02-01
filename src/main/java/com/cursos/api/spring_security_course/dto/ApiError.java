package com.cursos.api.spring_security_course.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ApiError implements Serializable {

    private String backedMessage;

    private String message;
    private String url;
    private String method;
    private int httpCode;

    private LocalDateTime time;

    public String getBackedMessage() {
        return backedMessage;
    }

    public void setBackedMessage(String backedMessage) {
        this.backedMessage = backedMessage;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

