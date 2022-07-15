package org.example.rest.costumer;

import lombok.RequiredArgsConstructor;
import org.example.rest.response.ResponseDto;
import org.example.domain.costumer.CostumerEntity;
import org.example.service.costumer.CostumerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/costumer")
@RequiredArgsConstructor
public class CostumerController {

    private final CostumerService service;
    private final CostumerDtoMapper mapper;
    private final CostumerSaveDtoMapper saveMapper;
    private final CostumerEditDtoMapper editMapper;

    @PostMapping
    public ResponseDto<Void> save(@RequestBody @Valid CostumerSaveDto dto) {
        CostumerEntity entity = saveMapper.mapToEntity(dto);
        service.save(entity);
        return new ResponseDto<>("Cadastro realizado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseDto<Void> update(@PathVariable Long id, @RequestBody @Valid CostumerEditDto dto) {
        CostumerEntity entity = editMapper.mapToEntity(dto);
        service.update(id, entity);
        return new ResponseDto<>("Edição realizada com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseDto<CostumerDto> findById(@PathVariable Long id) {
        CostumerEntity entity = service.findById(id);
        CostumerDto dto = mapper.mapToDto(entity);
        return new ResponseDto<>(dto);
    }
}
