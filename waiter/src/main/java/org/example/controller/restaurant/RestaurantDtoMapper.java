package org.example.controller.restaurant;

import lombok.RequiredArgsConstructor;
import org.example.controller.address.AddressDtoMapper;
import org.example.data.restaurant.RestaurantEntity;
import org.example.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantDtoMapper extends AbstractMapper<RestaurantEntity, RestaurantDto> {

    private final AddressDtoMapper addressMapper;

    @Override
    public RestaurantDto mapToDto(RestaurantEntity entity) {
        return new RestaurantDto(
                entity.getId(),
                entity.getName(),
                entity.getPhoneNumber(),
                addressMapper.mapToDto(entity.getAddress())
        );
    }
}
