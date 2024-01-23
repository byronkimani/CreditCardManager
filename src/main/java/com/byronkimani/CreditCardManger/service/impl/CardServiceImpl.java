package com.byronkimani.CreditCardManger.service.impl;

import com.byronkimani.CreditCardManger.model.Account;
import com.byronkimani.CreditCardManger.model.Card;
import com.byronkimani.CreditCardManger.repository.AccountRepository;
import com.byronkimani.CreditCardManger.repository.CardRepository;
import com.byronkimani.CreditCardManger.service.AccountService;
import com.byronkimani.CreditCardManger.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;


    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Long id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public void updateCard(Card card) {
        final Card newCard = cardRepository.findById(card.getId()).get();

        newCard.setType(card.getType());

        cardRepository.save(newCard);
    }

    @Override
    public Boolean deleteById(Long id) {
        cardRepository.deleteById(id);
        return true;
    }
}
