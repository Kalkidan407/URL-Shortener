package com.urlshrtner.project.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ErrorResponse {
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    
    private int status;
    
    
    private String message;
    
    private String requestPath;
}



// ErrorResponse errorResponse = ErrorResponse.builder()
//         .timestamp(LocalDateTime.now())
//         .status(HttpStatus.NOT_FOUND.value())
//         .error(HttpStatus.NOT_FOUND.getReasonPhrase())
//         .message(exception.getMessage())
//         .requestPath(request.getRequestURI())
//         .build();
