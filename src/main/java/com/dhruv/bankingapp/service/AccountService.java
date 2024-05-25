package com.dhruv.bankingapp.service;

import com.dhruv.bankingapp.dto.AccountDto;


public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

}
