package com.survey.etheriumerccontract.token;

import me.gjeanmart.tutorials.javaethereum.contracts.generated.IXToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class ERC20Factory {

    private ERC20Factory(){}

    public static IXToken getInstance(String uri, String privateKey, String contractAddress) {
        Credentials credentials = Credentials.create(privateKey);
        Web3j web3j = Web3j.build(new HttpService(uri));
        BigInteger gasPrice = BigInteger.valueOf(3333300L);
        BigInteger gasLimit = BigInteger.valueOf(6721975L);
        return IXToken.load(contractAddress,web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
    }

}