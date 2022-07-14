package org.example.controller.costumer;

import lombok.RequiredArgsConstructor;
import org.example.data.costumer.CostumerEntity;
import org.example.mapper.AbstractSaveMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CostumerEditDtoMapper extends AbstractSaveMapper<CostumerEntity, CostumerEditDto> {

    @Override
    public CostumerEntity mapToEntity(CostumerEditDto dto) {
        return new CostumerEntity(
                dto.getName(),
                dto.getLastname(),
                dto.getEmail(),
                dto.getPhoneNumber()
        );
    }
}
