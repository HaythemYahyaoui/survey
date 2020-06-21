package com.survey.etheriumerccontract.token;

import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;

import java.math.BigInteger;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IXTokenTest {

    String uri = "HTTP://127.0.0.1:8548";
    String contractAddress = "0x2F15E55c19B11268B4ED14540ed253aA937A9670";

    String masterAccountPublicKey = "0xe6002baE124bEB71302C60E23B3DDd560AfDA8c4";
    String masterAccountPrivateKey = "717ce092a1e519ff34e5bcb264718912ecfaf043c2e5fdba63e53e7889dea21b";

    String client1AccountPublicKey = "0x55Ef193296E3B1D6749D12768b886DCF438d7580";
    String client1AccountPrivateKey = "817405bbb015817455f12cbe12baf905886d9fee5d3d120b6f5f73429bb51e88";

    String holderAccountPublicKey = "0x36103Ef93B04399b81789F5Ee81a5644CB2bC029";
    String holderAccountPrivateKey = "96928832cb9761f55599bb4390331eea4fe1b3fc673caf0ee3fa23a7f9152b5d";

    String client2AccountPublicKey = "0xd0804D118E45BFa01bAA4E242f1a7Cb61C5f448d";
    String client2AccountPrivateKey = "67ebbdf359a3ec7ee785ce7b27d6204a1290580b3d9d3c0cbd402c6449cff7ae";

    String client3AccountPublicKey = "0x27dfC287C896B0E5DA2F581bcb624374eB52B9B7";
    String client3AccountPrivateKey = "fc0614bb741db4e7603a952ef65d3bdca98e98c58d485768fab12422d57454f5";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    /*
        ERC20
     */
    @Test
    void name() throws Exception {
         assertEquals("IXToken",ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).name().send());
    }

    @Test
    void symbol() throws Exception {
        assertEquals("IXT",ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).symbol().send());
    }

    @Test
    void decimals() throws Exception {
        assertEquals(BigInteger.valueOf(8L),ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).decimals().send());
    }

    @Test
    void totalSupply() throws Exception {
        assertEquals(BigInteger.valueOf(2100000000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).totalSupply().send());
    }

    @Test
    void balanceOf() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).balanceOf(client1AccountPublicKey).send());
    }

    @Test
    void transferFailInsufisientFound() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).balanceOf(client1AccountPublicKey).send());
        assertThrows(Exception.class,() -> {
            ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).transfer(masterAccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        });
    }

    @Test
    void transfer() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).balanceOf(client1AccountPublicKey).send());
        TransactionReceipt transactionReceipt =  ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).transfer(client1AccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).balanceOf(client1AccountPublicKey).send());
        transactionReceipt =  ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).transfer(masterAccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).balanceOf(client1AccountPublicKey).send());
    }

    @Test
    void allowance() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).allowance(masterAccountPublicKey, client1AccountPublicKey).send());
    }

    @Test
    void approve() throws Exception {
        TransactionReceipt transactionReceipt = ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).approve(client1AccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).allowance(masterAccountPublicKey, client1AccountPublicKey).send());
        transactionReceipt = ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).approve(client1AccountPublicKey, BigInteger.ZERO).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).allowance(masterAccountPublicKey, client1AccountPublicKey).send());
    }

    @Test
    void transferFromFailAmoutExceedAllowance() {
        assertThrows(Exception.class,() -> {
            ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).transferFrom(masterAccountPublicKey, client1AccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        });
    }

    @Test
    void transferFrom() throws Exception {
        TransactionReceipt transactionReceipt = ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).approve(client1AccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        transactionReceipt = ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).transferFrom(masterAccountPublicKey, client1AccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        transactionReceipt = ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).transfer(masterAccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertNotNull(transactionReceipt);
        assertNotNull(transactionReceipt.getTransactionHash());
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).balanceOf(client1AccountPublicKey).send());
    }

    /*
    ERC1996
     */
    @Test
    void balanceOnHold() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).balanceOnHold(client1AccountPublicKey).send());
    }

    @Test
    void netBalanceOf() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).netBalanceOf(client1AccountPublicKey).send());
    }

    @Test
    void totalSupplyOnHold() throws Exception {
        assertEquals(BigInteger.ZERO, ERC20Factory.getInstance(uri, client1AccountPrivateKey, contractAddress).totalSupplyOnHold().send());
    }

    @Test
    void hold() throws Exception {
        String uuid = UUID.randomUUID().toString();
        ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).hold(uuid, client3AccountPublicKey, masterAccountPublicKey, BigInteger.valueOf(10000000000L), BigInteger.valueOf(0L)).send();
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).totalSupplyOnHold().send());
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).balanceOnHold(masterAccountPublicKey).send());
        ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).executeHold(uuid, BigInteger.valueOf(10000000000L)).send();
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).netBalanceOf(client3AccountPublicKey).send());
        ERC20Factory.getInstance(uri, client3AccountPrivateKey, contractAddress).transfer(masterAccountPublicKey, BigInteger.valueOf(10000000000L)).send();
        assertEquals(BigInteger.valueOf(0L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).netBalanceOf(client3AccountPublicKey).send());
    }

    @Test
    void hold2() throws Exception {
        String uuid = UUID.randomUUID().toString();
        ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).hold(uuid, client3AccountPublicKey, holderAccountPublicKey, BigInteger.valueOf(10000000000L), BigInteger.valueOf(0L)).send();
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).totalSupplyOnHold().send());
        assertEquals(BigInteger.valueOf(10000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).balanceOnHold(masterAccountPublicKey).send());
        ERC20Factory.getInstance(uri, holderAccountPrivateKey, contractAddress).executeHold(uuid, BigInteger.valueOf(5000000000L)).send();
        assertEquals(BigInteger.valueOf(5000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).netBalanceOf(client3AccountPublicKey).send());
        assertEquals(BigInteger.valueOf(5000000000L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).balanceOf(client3AccountPublicKey).send());
        ERC20Factory.getInstance(uri, client3AccountPrivateKey, contractAddress).transfer(masterAccountPublicKey, BigInteger.valueOf(5000000000L)).send();
        assertEquals(BigInteger.valueOf(0L), ERC20Factory.getInstance(uri, masterAccountPrivateKey, contractAddress).netBalanceOf(client3AccountPublicKey).send());
    }

}