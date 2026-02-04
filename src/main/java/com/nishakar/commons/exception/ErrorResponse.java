package com.nishakar.commons.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ErrorResponse {
    public String errorMsg;
    public Integer statusCode;
    public String httpStatus;
    public String path;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    public LocalDateTime dateAndTime;
}
