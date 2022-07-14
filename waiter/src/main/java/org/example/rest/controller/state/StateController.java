package org.example.rest.controller.state;

import org.example.domain.data.state.StateEntity;
import org.example.domain.service.state.StateService;
import org.example.rest.controller.response.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public record StateController(
        StateService service,
        StateMapper mapper
) {

    @GetMapping
    public ResponseDto<List<StateDto>> findAll() {
        List<StateEntity> list = service.findAll();
        return new ResponseDto<>(mapper.mapToListDto(list));
    }
}
