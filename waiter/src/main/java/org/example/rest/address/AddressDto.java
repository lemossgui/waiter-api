package org.example.rest.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.rest.city.CityDto;
import org.example.rest.state.StateSimpleDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String street;
    private Long number;
    private String postalCode;
    private StateSimpleDto state;
    private CityDto city;
}
