package com.byronkimani.CreditCardManger.service.impl;

import com.byronkimani.CreditCardManger.exception.ApiException;
import com.byronkimani.CreditCardManger.model.User;
import com.byronkimani.CreditCardManger.repository.UserRepository;
import com.byronkimani.CreditCardManger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    @Override
    public User createUser(User user) {


        // Check if user password is strong
        // Check if user password is strong
        String password = user.getPassword();

        if (password == null || password.length() <= 2)
            throw new ApiException("Password must be at least 3 characters. Please use a stronger password and try again.");

        if (checkIfUserExists(user.getName()))
            throw new ApiException("User name already in use. Please use a different name and try again.");


        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).get();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUser(User user) {
        final User newUser = userRepository.findById(user.getId()).get();

        newUser.setAccounts(user.getAccounts());

        userRepository.save(newUser);
    }

    @Override
    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    private boolean checkIfUserExists(String name) {
        return userRepository.findByName(name).isPresent();
    }

}
