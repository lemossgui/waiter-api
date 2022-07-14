package org.example.controller.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.address.AddressDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private AddressDto address;
}
