package com.tgi_confession.tgi_confession_db.service;

import java.io.Serializable;

public interface BaseService<DResponse, ResponseList, TKey extends Serializable, TEntity> {

    ResponseList getAll();

    TEntity getById(TKey id);

    TEntity create(DResponse modelDto);

    TEntity update(TKey id, DResponse modelDto);

    TEntity delete(TKey id);
}
