package org.example.domain.service.category;

import org.example.domain.data.category.CategoryEntity;
import org.example.domain.data.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CategoryServiceImpl(
        CategoryRepository repository
) implements CategoryService {

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }
}
