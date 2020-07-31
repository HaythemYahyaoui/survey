package com.survey.application.domain.token.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransactionReceiptDTO {

    @EqualsAndHashCode.Include
    private String transactionHash;
    private BigInteger transactionIndex;
    private String blockHash;
    private BigInteger blockNumber;
    private BigInteger cumulativeGasUsed;
    private BigInteger gasUsed;
    private String contractAddress;
    private String root;
    private String status;
    private String from;
    private String to;
    private List<LogDTO> logs;
    private String logsBloom;
    private String revertReason;

}