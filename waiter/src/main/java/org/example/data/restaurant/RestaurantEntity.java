package org.example.data.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.data.AbstractEntity;
import org.example.data.address.AddressEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class RestaurantEntity extends AbstractEntity {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    public RestaurantEntity(String name) {
        this.name = name;
    }

    public RestaurantEntity(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
