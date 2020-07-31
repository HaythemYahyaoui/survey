package com.survey.application.infrastructure.criteria;


import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.application.domain.criteria.repository.CriteriaRepository;
import com.survey.application.infrastructure.criteria.repository.CriteriaSpringRepository;
import com.survey.application.infrastructure.errors.Error;
import com.survey.exception.InfrastructureException;

import java.util.Optional;

public class CriteriaAdapter implements CriteriaRepository<Long> {

    private CriteriaSpringRepository criteriaSpringRepository;

    public CriteriaAdapter(CriteriaSpringRepository criteriaSpringRepository) {
        this.criteriaSpringRepository = criteriaSpringRepository;
    }

    @Override
    public Criteria<Long> getById(Long id) throws InfrastructureException {
        Optional<Criteria> byId = criteriaSpringRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else{
            throw new InfrastructureException(Error.RESOURCE_NOT_FOUND);
        }
    }

    @Override
    public Criteria<Long> save(Criteria<Long> criteria) throws InfrastructureException {
        return criteriaSpringRepository.save(criteria);
    }

    @Override
    public void delete(Long id) throws InfrastructureException {
        Criteria<Long> criteria = this.getById(id);
        this.criteriaSpringRepository.deleteById(id);
    }

    @Override
    public void update(Criteria<Long> criteria) throws InfrastructureException {
        this.criteriaSpringRepository.save(criteria);
    }

}