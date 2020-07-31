package com.survey.ddd.repository;

import com.survey.ddd.domain.AbstractEntity;

public class AbstractRepository<T extends AbstractEntity<X>,X> implements IAbstractRepository<T,X> {

}
