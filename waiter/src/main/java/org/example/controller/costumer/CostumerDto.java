package org.example.controller.costumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.address.AddressDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CostumerDto {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private AddressDto address;
}
