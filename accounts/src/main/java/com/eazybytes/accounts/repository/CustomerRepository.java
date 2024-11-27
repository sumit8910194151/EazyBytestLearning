package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    /**
     * Finds a customer by their mobile number.
     *
     * @param mobileNumber the mobile number
     * @return an {@link Optional} of the customer, or an empty optional if no customer was found
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
