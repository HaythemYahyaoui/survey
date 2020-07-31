package com.survey.application.presentation.criteria.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateCriteriaModel {

    @NotNull(message = "Search price must be not null")
    @Min(value = 0, message = "Search price must be greater or equal to 0")
    private Float searchPrice;

    @NotNull(message = "Share price must be not null")
    @Min(value = 0, message = "Share price must be greater or equal to 0")
    private Float sharePrice;

    @NotNull(message = "Value must be not null")
    private Serializable value;

    @NotNull(message = "Criteria type must be not null")
    private Long criteriaTypeId;

}
