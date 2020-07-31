package com.survey.application.domain.token.impl;

import com.survey.application.domain.token.api.IXTokenBusiness;
import com.survey.application.domain.token.spi.IXTokenSPI;
import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;

import java.math.BigInteger;

public class IXTokenBusinessImpl implements IXTokenBusiness {

    private IXTokenSPI iXTokenSPI;

    public IXTokenBusinessImpl(IXTokenSPI iXTokenSPI) {
        this.iXTokenSPI = iXTokenSPI;
    }

    @Override
    public BigInteger totalSupply() throws Exception {
        return iXTokenSPI.totalSupply();
    }

    @Override
    public String name() throws Exception {
        return iXTokenSPI.name();
    }

    @Override
    public String symbol() throws Exception {
        return iXTokenSPI.symbol();
    }

    @Override
    public BigInteger decimals() throws Exception {
        return iXTokenSPI.decimals();
    }

    @Override
    public BigInteger balanceOf(String account) throws Exception {
        return iXTokenSPI.balanceOf(account);
    }

    @Override
    public TransactionReceiptDTO transfer(String recipient, BigInteger amount) throws Exception {
        return iXTokenSPI.transfer(recipient, amount);
    }

}
