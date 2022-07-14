package org.example.controller.state;

import lombok.RequiredArgsConstructor;
import org.example.controller.city.CityMapper;
import org.example.data.state.StateEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateMapper extends AbstractMapper<StateEntity, StateDto> {

    private final CityMapper cityMapper;

    @Override
    public StateDto mapToDto(StateEntity entity) {
        return new StateDto(
                entity.getId(),
                entity.getDescription(),
                entity.getUf(),
                cityMapper.mapToListDto(entity.getCities())
        );
    }

    @Override
    public StateEntity mapToEntity(StateDto dto) {
        return new StateEntity(
                dto.getDescription(),
                dto.getUf()
        );
    }
}
