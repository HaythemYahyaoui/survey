package com.survey.application.domain.criteriatype.entity.impl;

import com.survey.application.domain.criteriatype.enums.CriteriaBinding;
import com.survey.application.domain.criteriatype.enums.JavaType;
import com.survey.ddd.domain.AbstractEntity;
import com.survey.ddd.domain.IAbstractEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CriteriaTypeImpl extends AbstractEntity<Long> implements IAbstractEntity<Long> {

    private CriteriaBinding criteriaBinding;
    private JavaType javaType;

}
