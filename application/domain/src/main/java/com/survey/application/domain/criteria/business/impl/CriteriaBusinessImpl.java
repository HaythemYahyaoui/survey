package com.survey.application.domain.criteria.business.impl;

import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.application.domain.criteria.business.CriteriaBusiness;
import com.survey.application.domain.criteria.business.dto.CreateCriteria;
import com.survey.application.domain.criteria.business.dto.UpdateCriteria;
import com.survey.application.domain.criteria.repository.CriteriaRepository;
import com.survey.application.domain.criteria.business.mapper.CriteriaMapper;
import com.survey.exception.DomainException;
import com.survey.ddd.service.AbstractBusiness;

import com.survey.exception.InfrastructureException;

public class CriteriaBusinessImpl extends AbstractBusiness<Criteria<Long>,Long> implements CriteriaBusiness<Long> {

    private CriteriaRepository criteriaRepository;
    private CriteriaMapper criteriaMapper;

    public CriteriaBusinessImpl(CriteriaRepository criteriaRepository, CriteriaMapper criteriaMapper) {
        this.criteriaMapper = criteriaMapper;
        this.criteriaRepository = criteriaRepository;
    }

    @Override
    public Criteria<Long> getById(Long id) throws DomainException, InfrastructureException {
        return criteriaRepository.getById(id);
    }

    @Override
    public Criteria<Long> create(CreateCriteria createCriteria) throws DomainException, InfrastructureException {
        return criteriaRepository.save(criteriaMapper.getInstance(createCriteria));
    }

    @Override
    public void delete(Long id) throws DomainException, InfrastructureException {
        criteriaRepository.delete(id);
    }

    @Override
    public void update(Long id, UpdateCriteria updateCriteria) throws DomainException, InfrastructureException {
        criteriaRepository.update(criteriaMapper.getInstance(updateCriteria));
    }

}
