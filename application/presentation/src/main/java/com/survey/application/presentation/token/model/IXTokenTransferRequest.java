package com.survey.application.presentation.token.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class IXTokenTransferRequest {

    private String recipient;
    private BigInteger amount;

}
