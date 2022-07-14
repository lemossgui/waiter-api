package org.example.controller.costumer;

import lombok.RequiredArgsConstructor;
import org.example.controller.address.AddressSaveDtoMapper;
import org.example.data.costumer.CostumerEntity;
import org.example.mapper.AbstractSaveMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CostumerSaveDtoMapper extends AbstractSaveMapper<CostumerEntity, CostumerSaveDto> {

    private final AddressSaveDtoMapper addressMapper;

    @Override
    public CostumerEntity mapToEntity(CostumerSaveDto dto) {
        return new CostumerEntity(
                dto.getName(),
                dto.getLastname(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getPhoneNumber(),
                addressMapper.mapToEntity(dto.getAddress())
        );
    }
}
