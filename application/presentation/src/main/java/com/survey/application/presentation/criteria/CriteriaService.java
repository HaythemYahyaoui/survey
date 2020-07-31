package com.survey.application.presentation.criteria;

import com.survey.application.domain.criteria.business.CriteriaBusiness;
import com.survey.application.domain.criteria.business.dto.CreateCriteria;
import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.exception.DomainException;
import com.survey.application.presentation.criteria.mapper.CriteriaModelMapper;
import com.survey.application.presentation.criteria.model.CreateCriteriaModel;
import com.survey.exception.InfrastructureException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Log4j2
@Service
@Validated
@Transactional
public class CriteriaService {

    @Autowired
    private CriteriaBusiness criteriaBusinessImpl;

    @Autowired
    private CriteriaModelMapper criteriaModelMapper;

    public Criteria create(@NotNull @Valid CreateCriteriaModel createCriteriaModel) throws DomainException, InfrastructureException {
        CreateCriteria createCriteria = criteriaModelMapper.getInstance(createCriteriaModel);
        createCriteria.setUser("SLASH");
        return criteriaBusinessImpl.create(createCriteria);
    }

    public Criteria getById(@NotNull Long id) throws DomainException, InfrastructureException {
        return criteriaBusinessImpl.getById(id);
    }

    public void delete(@NotNull Long id) throws DomainException, InfrastructureException {
        criteriaBusinessImpl.delete(id);
    }

}
