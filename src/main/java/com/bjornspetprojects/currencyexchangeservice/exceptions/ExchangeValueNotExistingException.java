package com.bjornspetprojects.currencyexchangeservice.exceptions;

public class ExchangeValueNotExistingException extends Exception {
    private String from;
    private String to;

    public ExchangeValueNotExistingException(String from, String to) {
        super("Conversion from "+from+" -> "+to+" is not configured!");
    }
}
