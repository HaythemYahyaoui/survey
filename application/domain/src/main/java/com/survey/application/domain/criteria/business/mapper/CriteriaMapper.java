package com.survey.application.domain.criteria.business.mapper;

import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.application.domain.criteria.business.dto.CreateCriteria;
import com.survey.application.domain.criteria.business.dto.UpdateCriteria;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CriteriaMapper {

    Criteria getInstance(CreateCriteria createCriteria);
    Criteria getInstance(UpdateCriteria updateCriteria);
}
