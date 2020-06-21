package com.survey.application.presentation.controller.controller.token;

import com.survey.application.domain.token.api.IXTokenBusiness;
import com.survey.application.domain.token.spi.dto.TransactionReceiptDTO;
import com.survey.application.presentation.controller.controller.token.model.IXTokenTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.logging.Logger;


@RestController
@RequestMapping("/IXToken")
public class IXTokenController {

	private static final Logger LOG = Logger.getLogger(IXTokenController.class.getName());

	@Autowired
	private IXTokenBusiness ixTokenBusinessImpl;

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
