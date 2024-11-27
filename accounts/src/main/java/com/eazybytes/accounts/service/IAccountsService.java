package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {


    /**
     * This method will create a new account for the given customer
     * @param customerDto contains the customer information
     */

    void createAccount(CustomerDto customerDto);


    /**
     * This method will fetch the customer information by given mobile number
     * @param mobileNumber the mobile number of the customer
     * @return a CustomerDto object that contains the customer information
     */
    CustomerDto fetchAccounts(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    /**
     * This method will delete the account associated with the given mobile number
     * @param mobileNumber the mobile number of the customer
     * @return true if the account is deleted successfully otherwise false
     */

    boolean deleteAccount(String mobileNumber);


}
