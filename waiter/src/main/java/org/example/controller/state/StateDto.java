package org.example.controller.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.city.CityDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateDto {
    private Long id;
    private String description;
    private String uf;
    private List<CityDto> cities;
}
