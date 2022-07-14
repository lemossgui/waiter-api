package org.example.controller.state;

import org.example.data.state.StateEntity;
import org.example.service.state.StateService;
import org.example.controller.response.ResponseDto;
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
