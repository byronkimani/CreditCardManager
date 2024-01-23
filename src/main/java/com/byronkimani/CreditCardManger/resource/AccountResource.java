package com.byronkimani.CreditCardManger.resource;

import com.byronkimani.CreditCardManger.domain.HttpResponse;
import com.byronkimani.CreditCardManger.model.Account;
import com.byronkimani.CreditCardManger.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static java.time.LocalTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountResource {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<HttpResponse> createAccount(@RequestBody Account account) {
        return ResponseEntity.created(getLocation(account.getId())).body(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", accountService.createAccount(account)))
                .message("Account created successfully")
                .httpStatus(CREATED)
                .statusCode(CREATED.value())
                .build());
    }

    @GetMapping
    public ResponseEntity<HttpResponse> getAllAccounts() {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", accountService.getAllAccounts()))
                .message("Accounts successfully retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @GetMapping
    public ResponseEntity<HttpResponse> getAccount(@PathVariable("id") Long id) {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", accountService.getAccountById(id)))
                .message("Account successfully retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @PutMapping
    public ResponseEntity<HttpResponse> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);

        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .message("Account updated successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @DeleteMapping
    public ResponseEntity<HttpResponse> deleteAccount(@PathVariable("id") Long id) {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", accountService.deleteById(id)))
                .message("Account deleted successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }


    protected static URI getLocation(Long id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}
