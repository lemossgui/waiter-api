package org.example.data.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.data.AbstractEntity;
import org.example.data.city.CityEntity;
import org.example.data.state.StateEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity extends AbstractEntity {

    @NotEmpty(message = "O campo rua/avenida é obrigatório")
    @Length(min = 3, max = 100, message = "O campo rua/avenida deve ter entre 3 e 100 caracteres")
    private String street;
    private Long number;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity state;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
}
