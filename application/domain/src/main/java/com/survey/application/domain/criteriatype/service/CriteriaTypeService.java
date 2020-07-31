package com.survey.application.domain.criteriatype.service;

import com.survey.application.domain.criteriatype.entity.CriteriaType;
import com.survey.application.domain.criteriatype.service.dto.CreateCriteriaType;
import com.survey.application.domain.criteriatype.service.dto.UpdateCriteriaType;
import com.survey.exception.DomainException;
import com.survey.ddd.service.IAbstractBusiness;
import com.survey.exception.InfrastructureException;

public interface CriteriaTypeService<X> extends IAbstractBusiness<CriteriaType<X>,X> {

    CriteriaType<X> getById(X id) throws DomainException, InfrastructureException;
    CriteriaType<X> create(CreateCriteriaType createCriteriaType) throws DomainException, InfrastructureException;
    void update(X id, UpdateCriteriaType updateCriteriaType) throws DomainException, InfrastructureException;
    void delete(X id) throws DomainException, InfrastructureException;

}
