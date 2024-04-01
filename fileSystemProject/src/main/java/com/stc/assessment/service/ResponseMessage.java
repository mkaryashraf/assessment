package com.stc.assessment.service;

import java.io.Serializable;

public class ResponseMessage {
    private String message;

    private Serializable body;

    public ResponseMessage(String message, Serializable body) {
        this.message = message;
        this.body= body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Serializable getBody() {
        return body;
    }

    public void setBody(Serializable body) {
        this.body = body;
    }
}
