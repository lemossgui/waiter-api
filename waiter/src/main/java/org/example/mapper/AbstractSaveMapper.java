package org.example.mapper;

import java.util.List;

public abstract class AbstractSaveMapper<E, D> {
    public abstract E mapToEntity(D dto);

    public List<E> mapToListEntity(List<D> list) {
        return list.stream().map(this::mapToEntity).toList();
    }
}
