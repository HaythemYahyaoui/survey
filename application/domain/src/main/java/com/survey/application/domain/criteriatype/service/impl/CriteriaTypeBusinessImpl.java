package com.survey.application.domain.criteriatype.service.impl;

import com.survey.application.domain.criteriatype.entity.CriteriaType;
import com.survey.application.domain.criteriatype.repository.CriteriaTypeRepository;
import com.survey.application.domain.criteriatype.service.CriteriaTypeService;
import com.survey.application.domain.criteriatype.service.dto.CreateCriteriaType;
import com.survey.application.domain.criteriatype.service.dto.UpdateCriteriaType;
import com.survey.application.domain.criteriatype.service.mapper.CriteriaTypeMapper;
import com.survey.exception.DomainException;
import com.survey.ddd.service.AbstractBusiness;
import com.survey.exception.InfrastructureException;

public class CriteriaTypeBusinessImpl extends AbstractBusiness<CriteriaType<Long>,Long> implements CriteriaTypeService<Long> {

    private CriteriaTypeRepository criteriaRepository;
    private CriteriaTypeMapper criteriaMapper;

    public CriteriaTypeBusinessImpl(CriteriaTypeRepository criteriaRepository, CriteriaTypeMapper criteriaMapper) {
        this.criteriaMapper = criteriaMapper;
        this.criteriaRepository = criteriaRepository;
    }
    
    @Override
    public CriteriaType<Long> getById(Long id) throws DomainException, InfrastructureException {
        return criteriaRepository.getById(id);
    }

    @Override
    public CriteriaType<Long> create(CreateCriteriaType createCriteria) throws DomainException, InfrastructureException {
        return criteriaRepository.save(criteriaMapper.getInstance(createCriteria));
    }

    @Override
    public void delete(Long id) throws DomainException, InfrastructureException {
        criteriaRepository.delete(id);
    }

    @Override
    public void update(Long id, UpdateCriteriaType updateCriteria) throws DomainException, InfrastructureException {
        criteriaRepository.update(criteriaMapper.getInstance(updateCriteria));
    }

}
