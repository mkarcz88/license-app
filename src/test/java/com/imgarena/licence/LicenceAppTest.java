package com.imgarena.licence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LicenceAppTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertTrue(restTemplate.getForEntity("/match/111", List.class).getStatusCode().is2xxSuccessful());
        assertThat(restTemplate.getForEntity("/match/111", List.class).getBody()).isEmpty();

        assertTrue(restTemplate.getForEntity("/match/10", List.class).getStatusCode().is2xxSuccessful());
        assertThat(restTemplate.getForEntity("/match/10", List.class).getBody()).isNotEmpty();
    }

}
