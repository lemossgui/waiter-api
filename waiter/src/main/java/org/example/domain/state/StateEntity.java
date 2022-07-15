package org.example.domain.state;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.city.CityEntity;
import org.example.domain.AbstractEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "state")
public class StateEntity extends AbstractEntity {
    private String description;
    private String uf;

    @OneToMany(mappedBy = "state")
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy("description")
    @JsonManagedReference
    private List<CityEntity> cities;

    public StateEntity(Long id) {
        super(id);
    }

    public StateEntity(String description, String uf) {
        this.description = description;
        this.uf = uf;
    }
}
