package com.bjornspetprojects.currencyexchangeservice.services;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;

import java.util.List;

public interface ExchangeValueService {
    public List<ExchangeValue> findAll();
    public ExchangeValue findByFromAndToIgnoreCase(String from, String to);
    public ExchangeValue save(ExchangeValue exchangeValue);
}
