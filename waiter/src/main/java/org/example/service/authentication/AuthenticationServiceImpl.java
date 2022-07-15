package org.example.service.authentication;

import lombok.RequiredArgsConstructor;
import org.example.domain.costumer.CostumerEntity;
import org.example.domain.costumer.CostumerRepository;
import org.example.domain.restaurant.RestaurantEntity;
import org.example.domain.restaurant.RestaurantRepository;
import org.example.rest.exception.NotFoundException;
import org.example.security.PayloadToken;
import org.example.security.UserTypeEnum;
import org.example.security.jwt.JwtService;
import org.example.utils.CryptUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CostumerRepository costumerRepository;
    private final RestaurantRepository restaurantRepository;
    private final JwtService jwtService;

    @Override
    public String doCostumerLogin(String email, String password) {
        Optional<CostumerEntity> found = costumerRepository.findByEmailAndPassword(email, CryptUtils.md5(password));
        return found.map(costumer -> {
            PayloadToken payloadToken = new PayloadToken(
                    costumer.getId(),
                    UserTypeEnum.COSTUMER.getValue()
            );
            return jwtService.generateToken(payloadToken);
        }).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }

    @Override
    public String doRestaurantLogin(String email, String password) {
        Optional<RestaurantEntity> found = restaurantRepository.findByEmailAndPassword(email, CryptUtils.md5(password));
        return found.map(restaurant -> {
            PayloadToken payloadToken = new PayloadToken(
                    restaurant.getId(),
                    UserTypeEnum.RESTAURANT.getValue()
            );
            return jwtService.generateToken(payloadToken);
        }).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }
}
