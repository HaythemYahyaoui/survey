package com.survey.application.infrastructure.criteria.repository;


import com.survey.application.domain.criteria.entity.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriteriaSpringRepository extends JpaRepository<Criteria,Long> {

}
