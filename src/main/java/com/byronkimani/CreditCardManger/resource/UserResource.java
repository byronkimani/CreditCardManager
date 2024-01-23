package com.byronkimani.CreditCardManger.resource;

import com.byronkimani.CreditCardManger.domain.HttpResponse;
import com.byronkimani.CreditCardManger.model.Card;
import com.byronkimani.CreditCardManger.model.User;
import com.byronkimani.CreditCardManger.service.CardService;
import com.byronkimani.CreditCardManger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.byronkimani.CreditCardManger.resource.AccountResource.getLocation;
import static java.time.LocalTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<HttpResponse> createUser(@RequestBody User user) {
        return ResponseEntity.created(getLocation(user.getId())).body(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", userService.createUser(user)))
                .message("User created successfully")
                .httpStatus(CREATED)
                .statusCode(CREATED.value())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", userService.findById(id)))
                .message("User successfully retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<HttpResponse> getUserByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", userService.findByName(name)))
                .message("User successfully retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @PutMapping
    public ResponseEntity<HttpResponse> updateUser(@RequestBody User user) {
        userService.updateUser(user);

        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .message("User updated successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(now().toString())
                .data(of("result", userService.deleteUser(id)))
                .message("User deleted successfully")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build());
    }


}
