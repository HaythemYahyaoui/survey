package com.survey.application.domain.criteria.business.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class UpdateCriteria {

    private Float searchPrice;
    private Float sharePrice;
    private Serializable value;

}
