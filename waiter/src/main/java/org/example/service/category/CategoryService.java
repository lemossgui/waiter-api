package org.example.service.category;

import org.example.domain.category.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryEntity> findAll();
}
