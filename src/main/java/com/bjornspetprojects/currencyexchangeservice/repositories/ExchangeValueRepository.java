package com.bjornspetprojects.currencyexchangeservice.repositories;

import com.bjornspetprojects.currencyexchangeservice.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
