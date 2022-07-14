package org.example.controller.costumer;

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
public class CostumerEditDto {

    @NotEmpty(message = "O campo nome é obrigatório")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String name;

    @NotEmpty(message = "O campo sobrenome é obrigatório")
    @Length(min = 3, max = 100, message = "O campo sobrenome deve ter entre 3 e 100 caracteres")
    private String lastname;

    @NotEmpty(message = "O campo e-mail é obrigatório")
    @Length(min = 3, max = 100, message = "O campo e-mail deve ter entre 3 e 100 caracteres")
    private String email;

    @NotEmpty(message = "O campo senha é obrigatório")
    @Length(min = 6, max = 20, message = "O campo senha deve ter entre 6 e 20 caracteres")
    private String phoneNumber;
}
