package com.byronkimani.CreditCardManger.resource;

import com.byronkimani.CreditCardManger.domain.HttpResponse;
import com.byronkimani.CreditCardManger.model.Account;
import com.byronkimani.CreditCardManger.model.Card;
import com.byronkimani.CreditCardManger.repository.AccountRepository;
import com.byronkimani.CreditCardManger.service.AccountService;
import com.byronkimani.CreditCardManger.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.byronkimani.CreditCardManger.resource.AccountResource.getLocation;
import static java.time.LocalTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardResource {
    private final CardService cardService;
    private final AccountRepository accountRepository;

    @PostMapping("/{accountId}")
    public ResponseEntity<HttpResponse> createCard(@PathVariable("accountId") Long accountId,@RequestBody Card card) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accountId));

        card.setAccount(account);

        return ResponseEntity.created(getLocation(card.getId())).body(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", cardService.createCard(card)))
                .message("Card created successfully")
                .httpStatus(CREATED)
                .statusCode(CREATED.value())
                .build());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<HttpResponse> getAllCardsByAccountId(@PathVariable("accountId") Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accountId));


        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", account.getCards()))
                .message("Cards successfully retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> updateCard(@PathVariable Long id , @RequestBody Card card) {
        card.setId(id);
        cardService.updateCard(card);

        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .message("Card updated successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteCard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", cardService.deleteById(id)))
                .message("Card deleted successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }


}
