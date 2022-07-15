package org.example.rest.state;

import lombok.RequiredArgsConstructor;
import org.example.rest.city.CityMapper;
import org.example.domain.state.StateEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateSimpleDtoMapper extends AbstractMapper<StateEntity, StateSimpleDto> {

    private final CityMapper cityMapper;

    @Override
    public StateSimpleDto mapToDto(StateEntity entity) {
        return new StateSimpleDto(
                entity.getId(),
                entity.getDescription(),
                entity.getUf()
        );
    }
}
