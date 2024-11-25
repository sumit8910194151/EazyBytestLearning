package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="account_number")
    @Id
    private Long accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;


}