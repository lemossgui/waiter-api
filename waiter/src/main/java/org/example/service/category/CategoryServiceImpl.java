package org.example.service.category;

import org.example.domain.category.CategoryEntity;
import org.example.domain.category.CategoryRepository;
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
