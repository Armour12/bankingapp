package com.dhruv.bankingapp.service.impl;

import com.dhruv.bankingapp.dto.AccountDto;
import com.dhruv.bankingapp.entity.Account;
import com.dhruv.bankingapp.mapper.AccountMapper;
import com.dhruv.bankingapp.repository.AccountRepository;
import com.dhruv.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto){
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
