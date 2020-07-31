package com.survey.application.infrastructure.token;

import com.survey.application.domain.token.spi.IXTokenSPI;
import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;
import com.survey.application.infrastructure.token.mapper.TransactionReceiptMapper;
import com.survey.etheriumerccontract.token.ERC20Factory;
import org.mapstruct.factory.Mappers;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public class IXTokenAdapter implements IXTokenSPI {

    private final String uri;
    private final String privateKey;
    private final String contractAddress;

    public IXTokenAdapter(String uri, String privateKey, String contractAddress) {
        this.uri = uri;
        this.privateKey = privateKey;
        this.contractAddress = contractAddress;
    }

    @Override
    public BigInteger totalSupply() throws Exception {
        return ERC20Factory.getInstance(uri, privateKey, contractAddress).totalSupply().send();
    }

    @Override
    public String name() throws Exception {
        return ERC20Factory.getInstance(uri, privateKey, contractAddress).name().send();
    }

    @Override
    public String symbol() throws Exception {
        return ERC20Factory.getInstance(uri, privateKey, contractAddress).symbol().send();
    }

    @Override
    public BigInteger decimals() throws Exception {
        return ERC20Factory.getInstance(uri, privateKey, contractAddress).decimals().send();
    }

    @Override
    public BigInteger balanceOf(String account) throws Exception {
        return ERC20Factory.getInstance(uri, privateKey, contractAddress).balanceOf(account).send();
    }

    @Override
    public TransactionReceiptDTO transfer(String recipient, BigInteger amount) throws Exception {
        TransactionReceipt transactionReceipt =  ERC20Factory.getInstance(uri, privateKey, contractAddress).transfer(recipient, amount).send();
        TransactionReceiptMapper transactionReceiptMapper = Mappers.getMapper( TransactionReceiptMapper.class );
        return transactionReceiptMapper.getInstance(transactionReceipt);
    }

}