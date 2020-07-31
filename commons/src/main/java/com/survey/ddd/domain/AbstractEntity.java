package com.survey.ddd.domain;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;



@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AbstractEntity<T> implements IAbstractEntity<T> {

    @EqualsAndHashCode.Include
    private T id;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdateDate;

    @Override
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Override
    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public void preUpdate(){
        lastUpdateDate = LocalDateTime.now();
    }

    @Override
    public void prePersist(){
        createdDate = LocalDateTime.now();
    }

}
