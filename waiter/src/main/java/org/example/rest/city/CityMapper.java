package org.example.rest.city;

import org.example.domain.city.CityEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class CityMapper extends AbstractMapper<CityEntity, CityDto> {

    @Override
    public CityDto mapToDto(CityEntity entity) {
        return new CityDto(
                entity.getId(),
                entity.getDescription()
        );
    }
}
