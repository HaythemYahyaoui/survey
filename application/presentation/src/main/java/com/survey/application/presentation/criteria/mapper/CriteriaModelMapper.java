package com.survey.application.presentation.criteria.mapper;

import com.survey.application.domain.criteria.business.dto.CreateCriteria;
import com.survey.application.presentation.criteria.model.CreateCriteriaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public abstract class CriteriaModelMapper {

    public abstract CreateCriteria getInstance(CreateCriteriaModel createCriteriaModel);

}
