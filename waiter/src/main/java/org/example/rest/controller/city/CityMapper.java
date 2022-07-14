package org.example.rest.controller.city;

import org.example.domain.data.city.CityEntity;
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

    @Override
    public CityEntity mapToEntity(CityDto dto) {
        return new CityEntity(
                dto.getDescription()
        );
    }
}
