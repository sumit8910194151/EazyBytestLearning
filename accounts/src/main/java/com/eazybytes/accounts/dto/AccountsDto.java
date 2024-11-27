package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {


    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    @NotEmpty(message = "Account number cannot be empty")
    private Long accountNumber;


    @NotEmpty(message = "Account type cannot be empty")
    private String accountType;

    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;
}
