package com.survey.etheriumerccontract.token;

import me.gjeanmart.tutorials.javaethereum.contracts.generated.IXToken;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import  org.junit.jupiter.api.Assertions;

class IXTokenFactoryTest {

    String uri = "https://ropsten.infura.io/v3/84a6a9f5b5eb4ccaa8d7e8b99f68adc7";
    String privateKey = "203E41B0BD8574173B87D6BA25D5E0B1550D41B1CF1327B62EB1A727885451CE";
    String contractAddress = "0xAe450EAD9157430d1fAc710Db8D8d101610c9F9F";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void getInstance() {
        Credentials credentials = Credentials.create(privateKey);
        Web3j web3j = Web3j.build(new HttpService(uri));
        BigInteger gasPrice = BigInteger.valueOf(52L);
        BigInteger gasLimit = BigInteger.valueOf(100000L);
        IXToken load = IXToken.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
        Assertions.assertNotNull(load);
    }

}