package org.example.rest.controller.state;

import lombok.RequiredArgsConstructor;
import org.example.domain.data.state.StateEntity;
import org.example.mapper.AbstractMapper;
import org.example.rest.controller.city.CityMapper;
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
