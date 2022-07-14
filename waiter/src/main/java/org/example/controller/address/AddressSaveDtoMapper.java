package org.example.controller.address;

import org.example.data.address.AddressEntity;
import org.example.data.city.CityEntity;
import org.example.data.state.StateEntity;
import org.example.mapper.AbstractSaveMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressSaveDtoMapper extends AbstractSaveMapper<AddressEntity, AddressSaveDto> {

    @Override
    public AddressEntity mapToEntity(AddressSaveDto dto) {
        return new AddressEntity(
                dto.getStreet(),
                dto.getNumber(),
                dto.getPostalCode(),
                new StateEntity(dto.getState().getId()),
                new CityEntity(dto.getCity().getId())
        );
    }
}
