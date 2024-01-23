package com.byronkimani.CreditCardManger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static org.hibernate.annotations.CascadeType.REMOVE;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Entity
public class Account {
    @Id
    @GeneratedValue
    @Schema(accessMode = READ_ONLY)
    private Long id;
    @Column(unique = true)
    private String iban;
    @Column(unique = true)
    private String bicSwift;
    @OneToMany(mappedBy = "account")
    @Cascade(REMOVE)
    @JsonIgnore
    private List<Card> cards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}

