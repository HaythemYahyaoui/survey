package com.survey.application.domain.criteriatype.repository;

import com.survey.application.domain.criteriatype.entity.CriteriaType;
import com.survey.ddd.repository.IAbstractRepository;
import com.survey.exception.InfrastructureException;


public interface CriteriaTypeRepository<X> extends IAbstractRepository<CriteriaType<X>,X> {

    CriteriaType<X> getById(X id) throws InfrastructureException;
    CriteriaType<X> save(CriteriaType<X> criteria) throws InfrastructureException;
    void delete(X id) throws InfrastructureException;
    void update(CriteriaType<X> criteria) throws InfrastructureException;

}
