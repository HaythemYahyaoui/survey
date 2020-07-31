package com.survey.application.domain.criteria.business;

import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.application.domain.criteria.business.dto.CreateCriteria;
import com.survey.application.domain.criteria.business.dto.UpdateCriteria;
import com.survey.exception.DomainException;
import com.survey.ddd.service.IAbstractBusiness;
import com.survey.exception.InfrastructureException;

public interface CriteriaBusiness<X> extends IAbstractBusiness<Criteria<X>,X> {

    Criteria<X> getById(X id) throws DomainException, InfrastructureException;
    Criteria<X> create(CreateCriteria createCriteria) throws DomainException, InfrastructureException;
    void delete(X id) throws DomainException, InfrastructureException;
    void update(X id, UpdateCriteria updateCriteria) throws DomainException, InfrastructureException;

}
