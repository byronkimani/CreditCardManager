package com.byronkimani.CreditCardManger.service;


import com.byronkimani.CreditCardManger.model.Card;

import java.util.List;

public interface CardService {
    Card createCard(Card card);

    //    Get all Cards
    List<Card> getAllCards();
    Card getCardById(Long id);

    //    Update Card
    void updateCard(Card card);

    //    Delete Card
    Boolean deleteById(Long id);
}
