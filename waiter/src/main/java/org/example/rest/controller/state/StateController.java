package org.example.rest.controller.state;

import lombok.RequiredArgsConstructor;
import org.example.domain.data.state.StateEntity;
import org.example.domain.service.state.StateService;
import org.example.rest.controller.response.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/state")
public class StateController {

    private final StateService service;
    private final StateMapper mapper;

    @GetMapping
    public ResponseDto<List<StateDto>> findAll() {
        List<StateEntity> list = service.findAll();
        return new ResponseDto<>(mapper.mapToListDto(list));
    }
}
