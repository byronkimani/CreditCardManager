package com.byronkimani.CreditCardManger.service;


import com.byronkimani.CreditCardManger.model.Card;
import com.byronkimani.CreditCardManger.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User findById(Long id);

    User findByName(String name);

    //    Update Card
    void updateUser(User user);

    //    Delete Card
    Boolean deleteUser(Long id);
}
