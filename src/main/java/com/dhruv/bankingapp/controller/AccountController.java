package com.dhruv.bankingapp.controller;

import com.dhruv.bankingapp.dto.AccountDto;
import com.dhruv.bankingapp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //Add Account Rest API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account REST API
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto=accountService.withDraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get All REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }


}
