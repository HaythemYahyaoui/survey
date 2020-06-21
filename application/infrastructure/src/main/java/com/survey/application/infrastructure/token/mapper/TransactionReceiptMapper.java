package com.survey.application.infrastructure.token.mapper;

import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;
import org.mapstruct.Mapper;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Mapper
public interface TransactionReceiptMapper {
    TransactionReceiptDTO getInstance(TransactionReceipt transactionReceipt);
}
