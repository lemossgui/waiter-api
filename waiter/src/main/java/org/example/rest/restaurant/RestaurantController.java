package org.example.rest.restaurant;

import lombok.RequiredArgsConstructor;
import org.example.rest.response.ResponseDto;
import org.example.domain.restaurant.RestaurantEntity;
import org.example.service.restaurant.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantDtoMapper mapper;
    private final RestaurantSaveDtoMapper saveMapper;
    private final RestaurantEditDtoMapper editMapper;

    @PostMapping
    public ResponseDto<Void> save(@RequestBody @Valid RestaurantSaveDto dto) {
        RestaurantEntity entity = saveMapper.mapToEntity(dto);
        service.save(entity);
        return new ResponseDto<>("Cadastro realizado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseDto<Void> update(@PathVariable Long id, @RequestBody @Valid RestaurantEditDto dto) {
        RestaurantEntity entity = editMapper.mapToEntity(dto);
        service.update(id, entity);
        return new ResponseDto<>("Edição realizada com sucesso!");
    }

    @GetMapping
    public ResponseDto<List<RestaurantDto>> findAll(RestaurantFilter filter, Pageable pageable) {
        RestaurantEntity entity = new RestaurantEntity(filter.getName());
        Page<RestaurantEntity> page = service.findAll(entity, pageable);
        List<RestaurantDto> list = mapper.mapToListDto(page.getContent());
        return new ResponseDto<>(list, page.getTotalPages(), page.getNumberOfElements());
    }

    @GetMapping("/{id}")
    public ResponseDto<RestaurantDto> findById(@PathVariable Long id) {
        RestaurantEntity entity = service.findById(id);
        RestaurantDto dto = mapper.mapToDto(entity);
        return new ResponseDto<>(dto);
    }
}
