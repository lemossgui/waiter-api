package org.example.mapper;

import java.util.List;

public abstract class AbstractMapper<E, D> {
    public abstract D mapToDto(E entity);

    public List<D> mapToListDto(List<E> list) {
        return list.stream().map(this::mapToDto).toList();
    }
}
