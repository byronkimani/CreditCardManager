package com.byronkimani.CreditCardManger.userResource;

import com.byronkimani.CreditCardManger.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceTests {
    private static RestTemplate restTemplate;

    @Autowired
    private TestH2UserRepository h2Repository;
    User testUser1 = new User(null, "testName","strongPassword", null);
    User testUser2 = new User(null, "testName2","strongPassword2", null);
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
    public void testCreateUser() {



        User response = restTemplate.postForObject(baseUrl, testUser2, User.class);
        System.out.println(testUser2.getPassword());
        assertEquals("testName", testUser1.getName());

		assertEquals(1, h2Repository.findAll().size());
    }

}
