package org.example.rest.controller.category;

import org.example.domain.data.category.CategoryEntity;
import org.example.domain.service.category.CategoryService;
import org.example.rest.controller.response.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public record CategoryController(
        CategoryService service,
        CategoryMapper mapper
) {

    @GetMapping
    public ResponseDto<List<CategoryDto>> findAll() {
        List<CategoryEntity> list = service.findAll();
        return new ResponseDto<>(mapper.mapToListDto(list));
    }
}
