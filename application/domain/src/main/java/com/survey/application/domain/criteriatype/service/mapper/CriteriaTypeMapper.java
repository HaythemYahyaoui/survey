package com.survey.application.domain.criteriatype.service.mapper;

import com.survey.application.domain.criteriatype.entity.CriteriaType;
import com.survey.application.domain.criteriatype.service.dto.CreateCriteriaType;
import com.survey.application.domain.criteriatype.service.dto.UpdateCriteriaType;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CriteriaTypeMapper {

    CriteriaType getInstance(CreateCriteriaType createCriteriaType);
    CriteriaType getInstance(UpdateCriteriaType updateCriteriaType);
}
