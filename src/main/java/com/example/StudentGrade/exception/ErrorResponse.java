package com.example.StudentGrade.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

    private LocalDate timestampe;
    private List<String> messages;

    public ErrorResponse(List<String> messages) {
        this.timestampe = LocalDate.now();
        this.messages = messages;
    }

    public ErrorResponse() {
    }

    public LocalDate getTimestampe() {
        return this.timestampe;
    }

    public void setTimestampe(LocalDate timestampe) {
        this.timestampe = timestampe;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
