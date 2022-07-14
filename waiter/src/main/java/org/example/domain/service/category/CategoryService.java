package org.example.domain.service.category;

import org.example.domain.data.category.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryEntity> findAll();
}
