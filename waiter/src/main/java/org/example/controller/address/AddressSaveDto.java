package org.example.controller.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.simpleAssociation.SimpleAssociationDto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressSaveDto {

    @NotEmpty(message = "O campo rua/avenida é obrigatório")
    @Length(min = 3, max = 100, message = "O campo rua/avenida deve ter entre 3 e 100 caracteres")
    private String street;
    private Long number;
    private String postalCode;

    @NotNull(message = "O campo estado é obrigatório")
    private SimpleAssociationDto state;

    @NotNull(message = "O campo cidade é obrigatório")
    private SimpleAssociationDto city;
}
