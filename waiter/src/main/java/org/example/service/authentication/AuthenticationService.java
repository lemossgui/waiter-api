package org.example.service.authentication;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    String doCostumerLogin(String email, String password);
    String doRestaurantLogin(String email, String password);
}
