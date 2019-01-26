package com.bjornspetprojects.currencyexchangeservice.services;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;
import com.bjornspetprojects.currencyexchangeservice.exceptions.ExchangeValueNotExistingException;

import java.util.List;

public interface ExchangeValueService {
    List<ExchangeValue> findAll();
    ExchangeValue findByFromAndToIgnoreCase(String from, String to)throws ExchangeValueNotExistingException;
    ExchangeValue save(ExchangeValue exchangeValue);
}
