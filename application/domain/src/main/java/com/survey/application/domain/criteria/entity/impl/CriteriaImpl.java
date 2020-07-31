package com.survey.application.domain.criteria.entity.impl;

import com.survey.application.domain.criteria.entity.Criteria;
import com.survey.application.domain.criteriatype.entity.CriteriaType;
import com.survey.ddd.domain.AbstractEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CriteriaImpl extends AbstractEntity<Long> implements Criteria<Long> {

    private String user;
    private Float searchPrice;
    private Float sharePrice;
    private Serializable value;
    private CriteriaType criteriaType;

}
