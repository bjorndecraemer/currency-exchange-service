package com.bjornspetprojects.currencyexchangeservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ExceptionResponse {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
