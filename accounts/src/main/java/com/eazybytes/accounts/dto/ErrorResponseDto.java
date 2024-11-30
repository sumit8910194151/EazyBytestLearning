package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(name="API path in the response", example = "api/create")
    private String apiPath;
    @Schema(name="error code in the response", example = "500")
    private HttpStatus errorCode;
    @Schema(name="error message  in the response", example = "INTERNAL SERVER ERROR")
    private String errorMessage;
    @Schema(name="Error time in the response")
    private LocalDateTime errorTime;
}
