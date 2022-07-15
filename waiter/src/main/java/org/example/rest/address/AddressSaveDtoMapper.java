package org.example.rest.address;

import org.example.domain.address.AddressEntity;
import org.example.domain.city.CityEntity;
import org.example.domain.state.StateEntity;
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
