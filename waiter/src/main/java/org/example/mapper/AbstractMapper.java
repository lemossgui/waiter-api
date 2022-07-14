package org.example.mapper;

import java.util.List;

public abstract class AbstractMapper<E, D> {
    public abstract D mapToDto(E entity);

    public abstract E mapToEntity(D dto);

    public List<D> mapToListDto(List<E> list) {
        return list.stream().map(this::mapToDto).toList();
    }

    public List<E> mapToListEntity(List<D> list) {
        return list.stream().map(this::mapToEntity).toList();
    }
}
