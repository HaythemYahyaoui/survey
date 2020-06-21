package com.survey.application.domain.token.spi;

import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;

import java.math.BigInteger;

public interface IXTokenSPI {

    BigInteger totalSupply() throws Exception;
    String name() throws Exception;
    String symbol() throws Exception;
    BigInteger decimals() throws Exception;
    BigInteger balanceOf(String account)throws Exception;
    TransactionReceiptDTO transfer(String recipient, BigInteger amount) throws Exception;
}
