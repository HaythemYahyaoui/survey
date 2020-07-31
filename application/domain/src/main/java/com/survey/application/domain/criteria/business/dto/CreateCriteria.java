package com.survey.application.domain.criteria.business.dto;

import com.survey.application.domain.criteriatype.entity.CriteriaType;
import lombok.Data;

import java.io.Serializable;


@Data
public class CreateCriteria {

    private String user;
    private Float searchPrice;
    private Float sharePrice;
    private Serializable value;
    private CriteriaType criteriaType;

}
