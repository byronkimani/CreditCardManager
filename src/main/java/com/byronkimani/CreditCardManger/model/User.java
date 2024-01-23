package com.byronkimani.CreditCardManger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static org.hibernate.annotations.CascadeType.REMOVE;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue
    @Schema(accessMode = READ_ONLY)
    private Long id;

    @Size(min=2, message = "Name should have at least 2 characters")
    private String name;

//    @Size(min=4, message = "Password should have at least 4 characters")
    @JsonProperty(access = WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @Cascade(REMOVE)
    private List<Account> accounts;
}
