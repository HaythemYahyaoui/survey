package com.survey.application.presentation.token;

import com.survey.application.domain.token.api.IXTokenBusiness;
import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;
import com.survey.application.presentation.token.model.IXTokenTransferRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@Log4j2
@RestController
@RequestMapping("/IXToken")
public class IXTokenController {

	@Autowired
	private IXTokenBusiness ixTokenBusinessImpl;

	@Value( "${com.survey.application.data}" )
	private String data;

	@GetMapping(path = "data", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<IXTokenTransferRequest> data()  {
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
		IXTokenTransferRequest iTokenTransferRequest =new IXTokenTransferRequest();
		iTokenTransferRequest.setAmount(BigInteger.valueOf(12L));
		iTokenTransferRequest.setRecipient("sda");
		return ResponseEntity.status(HttpStatus.OK).body(iTokenTransferRequest);
	}

	@GetMapping(path = "name")
	public ResponseEntity<String> name() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(ixTokenBusinessImpl.name());
	}

	@GetMapping(path = "symbol")
	public ResponseEntity<String> symbol() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(ixTokenBusinessImpl.symbol());
	}

	@GetMapping(path = "totalSupply")
	public ResponseEntity<BigInteger> totalSupply() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(ixTokenBusinessImpl.totalSupply());
	}

	@GetMapping(path = "decimals")
	public ResponseEntity<BigInteger> decimals() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(ixTokenBusinessImpl.decimals());
	}

	@GetMapping(path = "balanceOf/{account}")
	public ResponseEntity<BigInteger> balanceOf(@PathVariable( value = "account") String account) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(ixTokenBusinessImpl.balanceOf(account));
	}

	@PostMapping(path = "transfer", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TransactionReceiptDTO> transfer(@RequestBody IXTokenTransferRequest iXTokenTransferRequest) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(ixTokenBusinessImpl.transfer(iXTokenTransferRequest.getRecipient(), iXTokenTransferRequest.getAmount()));
	}

}
