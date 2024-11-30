package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name="Customer",
        description = "Schema to hold customer and Account information"
)
public class CustomerDto {


    @NotEmpty(message = "Name can not be null or empty")
    @Size(min=5,max=30,message = "Name must be between 5 to 30 characters")
    @Schema(description = "Name of the Customer", example = "Eazy Bytes")
    private String name;


    @NotEmpty(message = "email can not be null or empty")
    @Email(message = "Email address should be valid")
    @Schema(description = "Email of the Customer", example = "EazyBytes@bank.com")
    private String email;


    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
    @Schema(description = "Mobile number of customer", example = "1234567891")
    private String mobileNumber;

    @Schema(description = "Acoounts entity of the customer")
    private AccountsDto accountsDto;

}
