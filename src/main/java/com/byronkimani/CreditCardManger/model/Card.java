package com.byronkimani.CreditCardManger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Entity
public class Card {
    @Id
    @GeneratedValue
    @Schema(accessMode = READ_ONLY)
    private Long id;
    private String alias;
    private CardType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Account account;
}
