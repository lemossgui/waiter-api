package org.example.controller.restaurant;

import lombok.RequiredArgsConstructor;
import org.example.controller.address.AddressSaveDtoMapper;
import org.example.data.restaurant.RestaurantEntity;
import org.example.mapper.AbstractSaveMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantEditDtoMapper extends AbstractSaveMapper<RestaurantEntity, RestaurantEditDto> {

    private final AddressSaveDtoMapper addressMapper;

    @Override
    public RestaurantEntity mapToEntity(RestaurantEditDto dto) {
        return new RestaurantEntity(
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmail()
        );
    }
}
