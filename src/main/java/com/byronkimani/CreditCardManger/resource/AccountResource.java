package com.byronkimani.CreditCardManger.resource;

import com.byronkimani.CreditCardManger.domain.HttpResponse;
import com.byronkimani.CreditCardManger.model.Account;
import com.byronkimani.CreditCardManger.model.User;
import com.byronkimani.CreditCardManger.repository.UserRepository;
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
    private final UserRepository userRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<HttpResponse> createAccount(@PathVariable("userId") Long userId,@RequestBody Account account) {


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        account.setUser(user);


        return ResponseEntity.created(getLocation(account.getId())).body(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", accountService.createAccount(account)))
                .message("Account created successfully")
                .httpStatus(CREATED)
                .statusCode(CREATED.value())
                .build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<HttpResponse> getAccountsByUserId(@PathVariable("userId") Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));


        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", user.getAccounts()))
                .message("Account successfully retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> updateAccount(@PathVariable("id") Long id,@RequestBody Account account) {

        account.setId(id);

        accountService.updateAccount(account);

        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .message("Account updated successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @DeleteMapping("/{id}")
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
