package com.tgi_confession.tgi_confession_db.service.impl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tgi_confession.tgi_confession_db.service.BaseService;

@Service
public abstract class BaseServiceimpl<DResponse, ResponseList, TKey extends Serializable, TEntity>
        implements BaseService<DResponse, ResponseList, TKey, TEntity> {

    protected abstract JpaRepository<TEntity, TKey> getModelRepository();

    protected abstract TEntity getCreateRespond(DResponse modelDto);

    protected abstract TEntity getUpdateRespond(TKey id, DResponse modelDto);

    @Override
    public ResponseList getAll() {
        return (ResponseList) getModelRepository().findAll();
    }

    @Override
    public TEntity getById(TKey id) {
        Optional<TEntity> optionalResult = getModelRepository().findById(id);

        if (optionalResult.isEmpty()) {
            return null;
        }
        return optionalResult.get();
    }

    @Override
    public TEntity create(DResponse modelDto) {
        return getModelRepository().save(getCreateRespond(modelDto));
    }

    @Override
    public TEntity delete(TKey id) {
        Optional<TEntity> optionalResult = getModelRepository().findById(id);
        getModelRepository().deleteById(id);
        return optionalResult.get();
    }

    @Override
    public TEntity update(TKey id, DResponse modelDto) {
        return getModelRepository().save(getUpdateRespond(id, modelDto));
    }
}
