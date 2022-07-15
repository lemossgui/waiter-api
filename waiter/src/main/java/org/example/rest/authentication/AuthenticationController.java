package org.example.rest.authentication;

import lombok.RequiredArgsConstructor;
import org.example.rest.response.ResponseDto;
import org.example.service.authentication.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/costumer")
    public ResponseDto<String> doLoginConsumer(@RequestBody @Valid CredentialsDto dto) {
        String token = service.doCostumerLogin(dto.getEmail(), dto.getPassword());
        String message = "Usuário autenticado com sucesso!";
        return new ResponseDto<>(token, message);
    }

    @PostMapping("/restaurant")
    public ResponseDto<String> doLoginRestaurant(@RequestBody @Valid CredentialsDto dto) {
        String token = service.doRestaurantLogin(dto.getEmail(), dto.getPassword());
        String message = "Usuário autenticado com sucesso!";
        return new ResponseDto<>(token, message);
    }
}
