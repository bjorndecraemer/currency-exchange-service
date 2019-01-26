package com.bjornspetprojects.currencyexchangeservice.bootstrap;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;
import com.bjornspetprojects.currencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TestDataCommandLineRunner implements CommandLineRunner {

    private final ExchangeValueRepository exchangeValueRepository;

    public TestDataCommandLineRunner(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public void run(String... args) {
        exchangeValueRepository.save(new ExchangeValue("USD","INL",new BigDecimal(75)));
        exchangeValueRepository.save(new ExchangeValue("INL","USD",new BigDecimal(0.13333333)));
        exchangeValueRepository.save(new ExchangeValue("USD","EUR",new BigDecimal(0.88)));
        exchangeValueRepository.save(new ExchangeValue("EUR","USD",new BigDecimal(1.14)));
    }
}
