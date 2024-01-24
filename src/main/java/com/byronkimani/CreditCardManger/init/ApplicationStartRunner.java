package com.byronkimani.CreditCardManger.init;

import com.byronkimani.CreditCardManger.model.User;
import com.byronkimani.CreditCardManger.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1L, "Byron", "strongPassword", null);
        User user2 = new User(2L, "Kimani", "strongPassword", null);

        if(userRepository.findByName(user1.getName()).isEmpty() && userRepository.findById(user1.getId()).isEmpty()){
            userRepository.save(user1);
        }

        if(userRepository.findByName(user2.getName()).isEmpty() && userRepository.findById(user2.getId()).isEmpty()){
            userRepository.save(user2);
        }

    }
}
