package org.example.rest.restaurant;

import lombok.RequiredArgsConstructor;
import org.example.rest.address.AddressSaveDtoMapper;
import org.example.domain.restaurant.RestaurantEntity;
import org.example.mapper.AbstractSaveMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantSaveDtoMapper extends AbstractSaveMapper<RestaurantEntity, RestaurantSaveDto> {

    private final AddressSaveDtoMapper addressMapper;

    @Override
    public RestaurantEntity mapToEntity(RestaurantSaveDto dto) {
        return new RestaurantEntity(
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                dto.getPassword(),
                addressMapper.mapToEntity(dto.getAddress())
        );
    }
}
