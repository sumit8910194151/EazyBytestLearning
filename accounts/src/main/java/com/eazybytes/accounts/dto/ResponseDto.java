package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {

    @Schema(name="Status code in the response", example = "200")
    private String statusCode;
    @Schema(name="Message in the response", example = "CREATED")
    private String statusMsg;

}
