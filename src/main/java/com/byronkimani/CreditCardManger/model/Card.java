package com.byronkimani.CreditCardManger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Entity
public class Card {
    @Id
    @GeneratedValue
    private Long id;
    private String alias;
    private CardType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Account account;
}

