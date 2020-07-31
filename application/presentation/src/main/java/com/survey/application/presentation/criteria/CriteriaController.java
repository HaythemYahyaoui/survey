package com.survey.application.presentation.criteria;

import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.exception.DomainException;
import com.survey.application.presentation.criteria.model.CreateCriteriaModel;
import com.survey.exception.InfrastructureException;
import com.survey.ws.AbstractResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@Log4j2
@RestController
@RequestMapping("/criteria")
public class CriteriaController {

	@Autowired
	private CriteriaService criteriaService;

	@PostMapping(path = "create")
	public ResponseEntity<AbstractResponse> create(@RequestBody CreateCriteriaModel createCriteriaModel) throws DomainException, InfrastructureException {
		Criteria criteria = criteriaService.create(createCriteriaModel);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("criteria/{id}")
				.buildAndExpand(criteria.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public Criteria getById(@PathVariable( value = "id") Long id) throws DomainException, InfrastructureException {
		return criteriaService.getById(id);
	}

	@DeleteMapping(path = "delete/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable( value = "id") Long id) throws DomainException, InfrastructureException {
		criteriaService.delete(id);
	}

}
