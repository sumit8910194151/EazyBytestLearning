package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.AccountsConstant;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {


    private IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstant.STATUS_201, AccountsConstant.MESSAGE_201));

    }//ResponseDto


    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam String mobileNumber) {
  CustomerDto customerDto = iAccountsService.fetchAccounts(mobileNumber);
  return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto) {

        boolean isUpdated=iAccountsService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstant.STATUS_500, AccountsConstant.MESSAGE_500));
        }
    }


}
