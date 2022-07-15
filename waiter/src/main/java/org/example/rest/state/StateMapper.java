package org.example.rest.state;

import lombok.RequiredArgsConstructor;
import org.example.rest.city.CityMapper;
import org.example.domain.state.StateEntity;
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
}
