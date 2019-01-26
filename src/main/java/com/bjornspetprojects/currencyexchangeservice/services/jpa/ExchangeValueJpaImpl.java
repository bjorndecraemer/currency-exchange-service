package com.bjornspetprojects.currencyexchangeservice.services.jpa;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;
import com.bjornspetprojects.currencyexchangeservice.repositories.ExchangeValueRepository;
import com.bjornspetprojects.currencyexchangeservice.services.ExchangeValueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeValueJpaImpl implements ExchangeValueService {

    private final ExchangeValueRepository exchangeValueRepository;

    public ExchangeValueJpaImpl(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public List<ExchangeValue> findAll() {
        return exchangeValueRepository.findAll();
    }

    @Override
    public ExchangeValue findByFromAndToIgnoreCase(String from, String to) {
        Optional<ExchangeValue> exchangeValueOptional = findAll()
                .stream()
                .filter(exchangeValue ->
                    exchangeValue.getFrom_value().equalsIgnoreCase(from) && exchangeValue.getTo_value().equalsIgnoreCase(to)
                )
                .findFirst();
        if(exchangeValueOptional.isPresent()){
            return exchangeValueOptional.get();
        }
        else{
            return null;
        }
    }

    @Override
    public ExchangeValue save(ExchangeValue exchangeValue) {
        return exchangeValueRepository.save(exchangeValue);
    }
}
