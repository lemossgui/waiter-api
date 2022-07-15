package org.example.service.category;

import lombok.RequiredArgsConstructor;
import org.example.domain.category.CategoryEntity;
import org.example.domain.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }
}
