package org.example.controller.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEditDto {
    @NotEmpty(message = "O campo nome é obrigatório")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String name;
    private String phoneNumber;

    @NotEmpty(message = "O campo e-mail é obrigatório")
    @Length(min = 3, max = 100, message = "O campo e-mail deve ter entre 3 e 100 caracteres")
    private String email;
}
