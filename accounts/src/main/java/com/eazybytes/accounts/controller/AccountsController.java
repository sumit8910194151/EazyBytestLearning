package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.AccountsConstant;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(
        name="CRUD REST API for Accounts application",
        description="CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH and DELETE account details"
)
public class AccountsController {


    private IAccountsService iAccountsService;

    @PostMapping("/create")
    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer & Account inside EazyBanck "
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status code created"
    )
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstant.STATUS_201, AccountsConstant.MESSAGE_201));

    }//ResponseDto


    @GetMapping("/fetch")
    @Operation(
            summary = "Fetch Account REST API",
            description = "REST API to Fetch new Customer & Account inside EazyBanck "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code OK",
            content = @Content(
                    schema = @Schema(implementation = CustomerDto.class)
            )
    )
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam
                                                         @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
                                                         String mobileNumber) {
  CustomerDto customerDto = iAccountsService.fetchAccounts(mobileNumber);
  return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @PutMapping("/update")
    @Operation(
            summary = "Update Account REST API",
            description = "REST API to Update new Customer & Account inside EazyBanck "
    )
    @ApiResponses({
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code OK"
    ),
            @ApiResponse(
                    responseCode = "417",
                    description = "EXPECTATION FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)

            )
            )
    }
    )
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {

        boolean isUpdated=iAccountsService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstant.STATUS_417, AccountsConstant.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete Account REST API",
            description = "REST API to Delete new Customer & Account inside EazyBanck "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status code OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "EXPECTATION FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class))
            )}
    )
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                         @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
                                                         String mobileNumber) {

        boolean isDeleted=iAccountsService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstant.STATUS_417, AccountsConstant.MESSAGE_417_DELETE));
        }
    }


}
