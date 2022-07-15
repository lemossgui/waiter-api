package org.example.rest.address;

import lombok.RequiredArgsConstructor;
import org.example.rest.city.CityMapper;
import org.example.rest.state.StateSimpleDtoMapper;
import org.example.domain.address.AddressEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressDtoMapper extends AbstractMapper<AddressEntity, AddressDto> {

    private final StateSimpleDtoMapper stateMapper;
    private final CityMapper cityMapper;

    @Override
    public AddressDto mapToDto(AddressEntity entity) {
        return new AddressDto(
                entity.getId(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getPostalCode(),
                stateMapper.mapToDto(entity.getState()),
                cityMapper.mapToDto(entity.getCity())
        );
    }
}
