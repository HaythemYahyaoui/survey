package com.survey.application.domain.token.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Data
public class LogDTO {

    private boolean removed;
    private BigInteger logIndex;
    private BigInteger transactionIndex;
    private String transactionHash;
    private String blockHash;
    private BigInteger blockNumber;
    private String address;
    private String data;
    private String type;
    private List<String> topics;
}