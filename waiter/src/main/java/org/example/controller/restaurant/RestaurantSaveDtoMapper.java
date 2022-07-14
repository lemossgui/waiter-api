package org.example.controller.restaurant;

import lombok.RequiredArgsConstructor;
import org.example.controller.address.AddressSaveDtoMapper;
import org.example.data.restaurant.RestaurantEntity;
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
