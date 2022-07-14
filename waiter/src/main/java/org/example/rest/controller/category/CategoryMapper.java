package org.example.rest.controller.category;

import org.example.domain.data.category.CategoryEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends AbstractMapper<CategoryEntity, CategoryDto> {

    @Override
    public CategoryDto mapToDto(CategoryEntity entity) {
        return new CategoryDto(
                entity.getId(),
                entity.getDescription()
        );
    }

    @Override
    public CategoryEntity mapToEntity(CategoryDto dto) {
        return new CategoryEntity(
                dto.getDescription()
        );
    }
}
