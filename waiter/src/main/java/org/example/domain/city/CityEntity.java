package org.example.domain.city;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.AbstractEntity;
import org.example.domain.state.StateEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class CityEntity extends AbstractEntity {
    private String description;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private StateEntity state;

    public CityEntity(Long id) {
        super(id);
    }

    public CityEntity(String description) {
        this.description = description;
    }
}
