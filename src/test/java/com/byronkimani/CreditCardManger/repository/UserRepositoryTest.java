package com.byronkimani.CreditCardManger.repository;


import com.byronkimani.CreditCardManger.model.Account;
import com.byronkimani.CreditCardManger.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    User user;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

//        final List<Account> testAccounts = new ArrayList<>();
//
//        testAccounts.add(new Account(1L, "testIban", "testBicSwift", null, user));



        user = new User(1L, "Byron", "strongPassword", null );

        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        user = null;
        userRepository.deleteAll();
    }

    // existsByEmail tests
    @Test
    void testFindByName() {
        User testUser = userRepository.findByName("Byron").get();
        assertEquals(user.getName(), testUser.getName());
    }

    @Test
    void testExistsByEmail_NotFound() {
        Optional<User> testUser  = userRepository.findByName("Byron2");
        assertThat(testUser).isEmpty();
    }
}
