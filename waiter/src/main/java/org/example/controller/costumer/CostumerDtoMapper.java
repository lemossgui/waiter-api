package org.example.controller.costumer;

import lombok.RequiredArgsConstructor;
import org.example.controller.address.AddressDtoMapper;
import org.example.data.costumer.CostumerEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CostumerDtoMapper extends AbstractMapper<CostumerEntity, CostumerDto> {

    private final AddressDtoMapper addressMapper;

    @Override
    public CostumerDto mapToDto(CostumerEntity entity) {
        return new CostumerDto(
                entity.getId(),
                entity.getName(),
                entity.getLastname(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                addressMapper.mapToDto(entity.getAddress())
        );
    }
}
