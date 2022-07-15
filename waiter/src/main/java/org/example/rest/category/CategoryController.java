package org.example.rest.category;

import lombok.RequiredArgsConstructor;
import org.example.domain.category.CategoryEntity;
import org.example.rest.response.ResponseDto;
import org.example.service.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseDto<List<CategoryDto>> findAll() {
        List<CategoryEntity> list = service.findAll();
        return new ResponseDto<>(mapper.mapToListDto(list));
    }
}
