package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name="Accounts",
        description = "Schema to hold customer and Account information"
)
public class AccountsDto {


    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    @NotEmpty(message = "Account number cannot be empty")
    @Schema(description = "Account number of the customer", example = "1234569718")
    private Long accountNumber;


    @NotEmpty(message = "Account type cannot be empty")
    @Schema(description = "Account type for teh customer", example = "Savings")
    private String accountType;

    @NotEmpty(message = "Branch address cannot be empty")
    @Schema(description = "Branch address for the customer", example = "123, main steeet new york")
    private String branchAddress;
}
