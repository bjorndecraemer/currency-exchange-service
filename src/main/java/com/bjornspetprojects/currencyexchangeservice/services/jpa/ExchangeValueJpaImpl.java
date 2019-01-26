package com.bjornspetprojects.currencyexchangeservice.services.jpa;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;
import com.bjornspetprojects.currencyexchangeservice.exceptions.ExchangeValueNotExistingException;
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

//    public ExchangeValue findByFromAndToIgnoreCaseOld(String from, String to) {
//        Optional<ExchangeValue> exchangeValueOptional = findAll()
//                .stream()
//                .filter(exchangeValue ->
//                    exchangeValue.getFrom().equalsIgnoreCase(from) && exchangeValue.getTo().equalsIgnoreCase(to)
//                )
//                .findFirst();
//        return exchangeValueOptional.orElse(null);
//    }

    @Override
    public ExchangeValue findByFromAndToIgnoreCase(String from, String to) throws ExchangeValueNotExistingException{
        ExchangeValue byFromAndTo = exchangeValueRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
        if(byFromAndTo == null){
            throw new ExchangeValueNotExistingException(from,to);
        }
        return byFromAndTo;
    }

    @Override
    public ExchangeValue save(ExchangeValue exchangeValue) {
        return exchangeValueRepository.save(exchangeValue);
    }
}
