package com.bjornspetprojects.currencyexchangeservice.beans;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exchange_value")
public class ExchangeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_value")
    private String from;
    @Column(name = "to_value")
    private String to;
    private BigDecimal conversionMultiple;
    @Transient
    private Integer port;

    public ExchangeValue(String from, String to, BigDecimal conversionMultiple) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
