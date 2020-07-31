package com.survey.application.domain.criteriatype.service.dto;

import com.survey.application.domain.criteriatype.enums.CriteriaBinding;
import com.survey.application.domain.criteriatype.enums.JavaType;
import lombok.Data;

import java.io.Serializable;


@Data
public class UpdateCriteriaType {

    private CriteriaBinding criteriaBinding;
    private JavaType javaType;

}
