package com.survey.ddd.service;

import com.survey.ddd.domain.IAbstractEntity;

public abstract class AbstractBusiness<T extends IAbstractEntity<X>,X> implements IAbstractBusiness<T,X> {

}
