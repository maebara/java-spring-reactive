package com.poc.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private StackTraceElement[] stacktraceDetail;
    private String message;
    private int status;
}
