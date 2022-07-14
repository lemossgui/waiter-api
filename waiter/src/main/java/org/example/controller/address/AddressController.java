package org.example.controller.address;

import lombok.RequiredArgsConstructor;
import org.example.controller.response.ResponseDto;
import org.example.data.address.AddressEntity;
import org.example.service.address.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;
    private final AddressSaveDtoMapper saveMapper;

    @PutMapping("/{id}")
    public ResponseDto<Void> update(@PathVariable Long id, @RequestBody @Valid AddressSaveDto dto) {
        AddressEntity entity = saveMapper.mapToEntity(dto);
        service.update(id, entity);
        return new ResponseDto<>("Edição realizada com sucesso!");
    }
}
