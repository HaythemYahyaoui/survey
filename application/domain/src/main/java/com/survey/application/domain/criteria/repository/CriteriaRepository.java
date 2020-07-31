package com.survey.application.domain.criteria.repository;

import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.ddd.repository.IAbstractRepository;
import com.survey.exception.InfrastructureException;


public interface CriteriaRepository<X> extends IAbstractRepository<Criteria<X>,X> {

    Criteria<X> getById(X id) throws InfrastructureException;
    Criteria<X> save(Criteria<X> criteria) throws InfrastructureException;
    void delete(X id) throws InfrastructureException;
    void update(Criteria<X> criteria) throws InfrastructureException;

}
