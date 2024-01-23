package com.byronkimani.CreditCardManger.service.impl;

import com.byronkimani.CreditCardManger.model.Account;
import com.byronkimani.CreditCardManger.repository.AccountRepository;
import com.byronkimani.CreditCardManger.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void updateAccount(Account account) {
        final Account newAccount = accountRepository.findById(account.getId()).get();

        newAccount.setIban(account.getIban());
        newAccount.setIban(account.getBicSwift());

        accountRepository.save(newAccount);
    }

    @Override
    public Boolean deleteById(Long id) {
        accountRepository.deleteById(id);
        return true;
    }
}
