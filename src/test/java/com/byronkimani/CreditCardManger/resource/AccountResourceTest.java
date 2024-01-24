package com.byronkimani.CreditCardManger.resource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceTest {
    private static RestTemplate restTemplate;

    @Autowired
    private TestH2AccountRepository h2Repository;

    @LocalServerPort
    private int port;
    private String baseUrl = "http://localhost";

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(String.valueOf(port)).concat("/users");
    }

    @Test
    public void testCreateAccount() {

//        User testUser1 = new User(1L, "testName","123456", null);
//
//        User response = restTemplate.postForObject(baseUrl, testUser1, User.class);
//        assertEquals("testName", response.getName());
//        assertEquals(1, h2Repository.findAll().size());
    }
}
