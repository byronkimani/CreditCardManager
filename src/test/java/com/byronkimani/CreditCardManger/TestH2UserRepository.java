package com.byronkimani.CreditCardManger;

import com.byronkimani.CreditCardManger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestH2UserRepository extends JpaRepository<User, Long> {
}
