package com.survey.application.domain.criteriatype.enums;

import java.time.LocalDate;

public enum JavaType {

    LONG(Long.class),
    DOUBLE(Double.class),
    DATE(LocalDate.class),
    STRING(String.class),
    BOOLEAN(Boolean.class);

    private Class<?> clazz;

    JavaType(Class<?> clazz){
        this.clazz = clazz;
    }

    public Class getJavaTypeClass(){
        return this.clazz;
    }
}
