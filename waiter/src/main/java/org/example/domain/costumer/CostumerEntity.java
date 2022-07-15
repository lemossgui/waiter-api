package org.example.domain.costumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.AbstractEntity;
import org.example.domain.address.AddressEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "costumer")
public class CostumerEntity extends AbstractEntity {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    public CostumerEntity(String name, String lastname, String email, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
