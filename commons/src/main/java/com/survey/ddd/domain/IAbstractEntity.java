package com.survey.ddd.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface IAbstractEntity<T> extends Serializable {
    void setId(T id);
    T getId();
    LocalDateTime getCreatedDate();
    void setCreatedDate(LocalDateTime createdDate);
    LocalDateTime getLastUpdateDate();
    void setLastUpdateDate(LocalDateTime lastUpdateDate);
    void preUpdate();
    void prePersist();
}
