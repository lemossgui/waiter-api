package org.example.controller.address;

import lombok.RequiredArgsConstructor;
import org.example.controller.city.CityMapper;
import org.example.controller.state.StateSimpleDtoMapper;
import org.example.data.address.AddressEntity;
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
