package com.bjornspetprojects.currencyexchangeservice.controllers;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;
import com.bjornspetprojects.currencyexchangeservice.exceptions.ExchangeValueNotExistingException;
import com.bjornspetprojects.currencyexchangeservice.services.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Environment environment;
    private ExchangeValueService exchangeValueService;


    public CurrencyExchangeController(Environment environment, ExchangeValueService exchangeValueService) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws ExchangeValueNotExistingException {
        ExchangeValue exchangeValue = exchangeValueService.findByFromAndToIgnoreCase(from,to);
        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        logger.info("{}", exchangeValue);
        return ResponseEntity.ok(exchangeValue);
    }
}
