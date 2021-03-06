package org.example.rest.category;

import org.example.domain.category.CategoryEntity;
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
}
