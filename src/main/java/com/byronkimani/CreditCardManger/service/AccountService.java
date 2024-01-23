package com.byronkimani.CreditCardManger.service;


import com.byronkimani.CreditCardManger.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);

    //    Get all Account
    List<Account> getAllAccounts();
    Account getAccountById(Long id);

    //    Update Account
    void updateAccount(Account account);

    //    Delete Account
    Boolean deleteById(Long id);
}
