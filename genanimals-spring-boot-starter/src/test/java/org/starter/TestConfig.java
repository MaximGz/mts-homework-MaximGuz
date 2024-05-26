package org.starter;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.starter.service.NamesListService;

@TestConfiguration
public class TestConfig {
    @Bean
    public NamesListService namesListServiceTest() {
        return new NamesListService();
    }
}
