package com.byronkimani.CreditCardManger.resource;

import com.byronkimani.CreditCardManger.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2AccountRepository extends JpaRepository<Account, Long> {
}