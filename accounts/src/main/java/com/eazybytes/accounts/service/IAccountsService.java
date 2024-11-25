package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {


    /**
     * This method will create a new account for the given customer
     * @param customerDto contains the customer information
     */

    void createAccount(CustomerDto customerDto);
}
