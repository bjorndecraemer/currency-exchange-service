package com.bjornspetprojects.currencyexchangeservice.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Data
@Table(name = "exchange_value")
public class ExchangeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String from_value;
    private String to_value;
    private BigDecimal conversionMultiple;
    @Transient
    private Integer port;

    public ExchangeValue() {
    }

    public ExchangeValue(String from_value, String to_value, BigDecimal conversionMultiple) {
        this.from_value = from_value;
        this.to_value = to_value;
        this.conversionMultiple = conversionMultiple;
    }

    public ExchangeValue(String from_value, String to_value, BigDecimal conversionMultiple, Integer port) {
        this.from_value = from_value;
        this.to_value = to_value;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
    }
}
