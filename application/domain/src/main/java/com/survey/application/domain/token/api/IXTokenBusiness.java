package com.survey.application.domain.token.api;

import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;

import java.math.BigInteger;

public interface IXTokenBusiness {

    BigInteger totalSupply() throws Exception;
    String name() throws Exception;
    String symbol() throws Exception;
    BigInteger decimals() throws Exception;
    BigInteger balanceOf(String account) throws Exception;
    TransactionReceiptDTO transfer(String recipient, BigInteger amount) throws Exception;
}
